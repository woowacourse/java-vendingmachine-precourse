package vendingmachine.controller;

import java.util.Map;

import vendingmachine.model.domain.Coin;
import vendingmachine.model.domain.VendingMachine;
import vendingmachine.model.service.VendingMachineService;
import vendingmachine.util.Utils;
import vendingmachine.validator.Validator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();
	Validator validator = new Validator();
	VendingMachineService vendingMachineService = new VendingMachineService();

	public void runMachine() {
		VendingMachine vendingMachine = new VendingMachine();
		enterAndGenerateMachineMoney(vendingMachine);
		printCurrentCoin(vendingMachine);
		enterAndGenerateMachineProduct(vendingMachine);
		enterAndGenerateInsertMoney(vendingMachine);
		purchaseProduct(vendingMachine);
		printRemainCoin(vendingMachine);
	}

	private void enterAndGenerateInsertMoney(VendingMachine vendingMachine) {
		String insertMoney = enterInsertMoney();
		int convertedInsertMoney = Utils.moneyConverter(insertMoney);

		vendingMachine.initInputMoney(convertedInsertMoney);
	}

	private void enterAndGenerateMachineMoney(VendingMachine vendingMachine) {
		String machineMoney = enterMachineMoney();
		int convertedMachineMoney = Utils.moneyConverter(machineMoney);

		vendingMachine.generateCoin(convertedMachineMoney);
	}

	private void enterAndGenerateMachineProduct(VendingMachine vendingMachine) {
		while (true) {
			try {
				String products = enterMachineProduct();
				vendingMachineService.generateProduct(vendingMachine, products);
				break;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private void purchaseProduct(VendingMachine vendingMachine) {
		outputView.printInsertMoney(vendingMachine.getInputMoney());

		while (vendingMachineService.end(vendingMachine)) {
			try {
				String productName = enterBuyingProduct();
				vendingMachineService.purchase(vendingMachine, productName);
				outputView.printInsertMoney(vendingMachine.getInputMoney());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private void printCurrentCoin(VendingMachine vendingMachine) {
		System.out.println(OutputView.MACHINE_MONEY);
		outputView.printCoinChange(vendingMachine.getCoinMap());
	}

	private void printRemainCoin(VendingMachine vendingMachine) {
		Map<Coin, Integer> remainCoin = vendingMachineService.calculateRemainCoin(vendingMachine.getInputMoney(),
			vendingMachine.getCoinMap());
		System.out.println(OutputView.CHANGE);
		outputView.printCoinChange(remainCoin);
	}

	private String enterMachineMoney() {
		String machineMoney = inputView.enterMachineMoney();
		try {
			return validator.validateMoney(machineMoney);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return enterMachineMoney();
		}
	}

	private String enterInsertMoney() {
		String insertMoney = inputView.enterBuyingMoney();
		try {
			return validator.validateMoney(insertMoney);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return enterInsertMoney();
		}
	}

	private String enterMachineProduct() {
		String machineProduct = inputView.enterMachineProduct();
		try {
			return validator.validateProduct(machineProduct);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return enterMachineProduct();
		}
	}

	private String enterBuyingProduct() {
		String buyingProduct = inputView.enterBuyingProduct();
		try {
			return validator.validateBuyingProduct(buyingProduct);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return enterBuyingProduct();
		}
	}
}
