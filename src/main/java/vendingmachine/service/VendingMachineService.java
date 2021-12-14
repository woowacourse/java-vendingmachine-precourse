package vendingmachine.service;

import vendingmachine.domain.VendingMachine;
import vendingmachine.message.Message;
import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.utils.ChangeUtil;
import vendingmachine.validation.validator.InputCostValidator;
import vendingmachine.validation.validator.InputProductNameValidator;
import vendingmachine.validation.validator.InputProductsValidator;
import vendingmachine.validation.validator.InputVendingMachineCostValidator;

public class VendingMachineService {

	private final ResponseMessage result;
	private final VendingMachine vendingMachine;

	public VendingMachineService() {
		this.vendingMachine = new VendingMachine();
		this.result = new ResponseMessage();
	}

	public String postVendingMachineCosts(String inputStr) {
		InputVendingMachineCostValidator.validateVendingMachineCost(inputStr);
		result.init();

		result.addMessage(Message.PRINT_COIN_IN_MACHINE.getMessage() + '\n');
		vendingMachine.makeCoinInCoinMap(Integer.parseInt(inputStr));
		result.addCoinCountMessage(vendingMachine.getCoinMap());

		return result.getResult();
	}

	public void postProductInfo(String inputStr) {
		vendingMachine.initProducts();
		InputProductsValidator.validateProducts(inputStr);

		vendingMachine.addProducts(inputStr.replaceAll("\\[", "").replaceAll("\\]", "").split(";"));
	}

	public void postInputCosts(String inputStr) {
		InputCostValidator.validateInputCost(inputStr);

		vendingMachine.canInputCostSet(Integer.parseInt(inputStr));
		ResponseMessage.printInputCost(vendingMachine.getInputCost());
	}

	public boolean postProductName(String inputStr) {
		InputProductNameValidator.validateProductName(inputStr, vendingMachine.getProducts());
		result.init();

		vendingMachine.subtractInputCostAndProductAmount(inputStr);
		ResponseMessage.printInputCost(vendingMachine.getInputCost());

		return vendingMachine.checkGetChange();
	}

	public String getChange() {
		result.init();

		result.addMessage(Message.PRINT_BALANCE.getMessage() + '\n');
		result.addCoinCountMessage(ChangeUtil.getMinimumChangeMap(vendingMachine.compareInputCostAndCoinToGetChange(),
			vendingMachine.getCoinMap()));

		return result.getResult();
	}
}



