package vendingmachine.controller;

import java.util.List;

import vendingmachine.dto.ProductDto;
import vendingmachine.exception.VendingMachineException;
import vendingmachine.view.output.message.OutputMessage;
import vendingmachine.service.MachineService;
import vendingmachine.view.input.InputView;
import vendingmachine.view.output.OutputView;

public class MachineControllerImpl implements MachineController {

	private MachineService machineService;
	private InputView inputView;
	private OutputView outputView;

	public MachineControllerImpl(MachineService machineService, InputView inputView, OutputView outputView) {
		this.machineService = machineService;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	@Override
	public void fillWithCoins() {
		outputView.printMessage(OutputMessage.REQUEST_MONEY_OF_MACHINE);
		callbackTemplate((inputView, machineService) -> {
			int moneyOfMachine = inputView.requestMoneyOfMachine();
			machineService.fillWithCoins(moneyOfMachine);
		});
		outputView.printEmptyNewLine();
	}

	@Override
	public void showCoinsOfMachine() {
		List<String> coinsOfMachine = machineService.getCoinsOfMachine();
		outputView.printCoinsOfMachine(coinsOfMachine);
		outputView.printEmptyNewLine();
	}

	@Override
	public void registerProducts() {
		outputView.printMessage(OutputMessage.REQUEST_PRODUCTS_FOR_REGISTER);
		callbackTemplate((inputView, machineService) -> {
			List<ProductDto> productDtos = inputView.requestProductDtos();
			machineService.saveProducts(productDtos);
		});
		outputView.printEmptyNewLine();
	}

	@Override
	public void depositMoney() {
		outputView.printMessage(OutputMessage.REQUEST_MONEY_OF_USER);
		callbackTemplate((inputView, machineService) -> {
			int moneyOfUser = inputView.requestMoneyOfUser();
			machineService.depositMoneyOfUser(moneyOfUser);
		});
		outputView.printEmptyNewLine();
	}

	@Override
	public void purchaseProducts() {
		while (machineService.isUserPossibleToUseMachine()) {
			showCurrentMoneyOfUser();
			purchaseProduct();
		}
	}

	private void showCurrentMoneyOfUser() {
		int currentMoneyOfUser = machineService.getCurrentMoneyOfUser();
		outputView.printCurrentMoneyOfUser(currentMoneyOfUser);
	}

	private void purchaseProduct() {
		outputView.printMessage(OutputMessage.REQUEST_PRODUCT_NAME_FOR_PURCHASE);
		callbackTemplate((inputView, machineService) -> {
			String productName = inputView.requestProductName();
			machineService.purchaseProduct(productName);
		});
		outputView.printEmptyNewLine();
	}

	@Override
	public void refundMoneyOfUser() {
		showCurrentMoneyOfUser();
		machineService.refundChanges();
		showCoinsOfUser();
	}

	private void showCoinsOfUser() {
		List<String> coinsOfUser = machineService.getCoinsOfUser();
		outputView.printCoinsOfUser(coinsOfUser);
		outputView.printEmptyNewLine();
	}

	private void callbackTemplate(Callback callback) {
		while (true) {
			try {
				callback.run(inputView, machineService);
				break;
			} catch (VendingMachineException ex) {
				outputView.printErrorMessage(ex.getMessage());
			}
		}
	}

}
