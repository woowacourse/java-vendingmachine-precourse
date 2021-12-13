package vendingmachine.service;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.message.Message;
import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.validation.validator.InputCostValidator;
import vendingmachine.validation.validator.InputProductNameValidator;
import vendingmachine.validation.validator.InputProductValidator;
import vendingmachine.validation.validator.InputProductsValidator;
import vendingmachine.validation.validator.InputVendingMachineCostValidator;

public class VendingMachineService {

	private final ResponseMessage result;
	private final VendingMachine vendingMachine;
	private int change;

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
		addProducts(inputStr);
	}

	public String postInputCosts(String inputStr) {
		InputCostValidator.validateInputCost(inputStr);
		result.init();
		vendingMachine.setInputCost(Integer.parseInt(inputStr));
		ResponseMessage.printInputCost(vendingMachine.getInputCost());

		return result.getResult();
	}

	public boolean postProductName(String inputStr) {
		InputProductNameValidator.validateProductName(inputStr, vendingMachine.getProducts());
		result.init();
		vendingMachine.subtractInputCostAndProductAmount(inputStr);
		ResponseMessage.printInputCost(vendingMachine.getInputCost());

		if (vendingMachine.checkGetChange()) {
			return true;
		}
		return false;
	}

	public String getChange() {
		result.init();
		result.addMessage(Message.PRINT_BALANCE.getMessage() + '\n');
		getMinimumChange();

		return result.getResult();
	}

	private void addProducts(String inputStr) {
		String[] products = inputStr.replaceAll("\\[", "").replaceAll("\\]", "").split(";");

		for (String rowProduct : products) {
			String[] product = rowProduct.split(",");
			InputProductValidator.validateProduct(product, vendingMachine.getProducts());
			vendingMachine.addProduct(
				new Product(product[0], Integer.parseInt(product[1]), Integer.parseInt(product[2])));
		}
	}

	private void getMinimumChange() {
		change = vendingMachine.compareInputCostAndCoinToDecideChange();
		Map<Integer, Integer> coinMap = vendingMachine.getCoinMap();
		Map<Integer, Integer> changeMap = new TreeMap<>(Collections.reverseOrder());
		for (Integer i : coinMap.keySet()) {
			changeMap = addChangeMapToValue(i, coinMap.get(i), changeMap);
		}

		result.addCoinCountMessage(changeMap);
	}

	private Map<Integer, Integer> addChangeMapToValue(int key, int value, Map<Integer, Integer> map) {
		for (int j = 0; j < value; j++) {
			if (change >= key) {
				map.put(key, map.getOrDefault(key, 0) + 1);
				change -= key;
			}
			if (change < key || change <= 0) {
				break;
			}
		}
		return map;
	}
}



