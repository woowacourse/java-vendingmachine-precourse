package vendingmachine.controller;

import static constant.CharacterConstant.*;
import static constant.StringConstant.*;

import exception.PriceException;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.PrintView;

public class ApplicationController {
	private VendingMachineService vendingMachineService;

	public ApplicationController(VendingMachineService vendingMachineService) {
		this.vendingMachineService = vendingMachineService;
	}

	public void startVendingMachine() {
		String vendingMachineBalance = InputView.getVendingMachineBalance();
		saveBalance(vendingMachineBalance);
	}

	private void saveBalance(String balance) {
		try {
			vendingMachineService.saveBalance(balance);
			saveCoins();
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + BALANCE_PRICE_PREFIX + e.getMessage() + LINE_STAMP);
			startVendingMachine();
		}
	}

	private void saveCoins() {
		vendingMachineService.saveCoins();
		PrintView.printVendingMachineCoins(vendingMachineService.getCoinMap());

		getProducts();
	}

	private void getProducts() {
		String userProducts = InputView.getVendingMachineProducts();
		saveProducts(userProducts);
	}

	private void saveProducts(String userProducts) {
		try {
			vendingMachineService.saveProductList(userProducts);
			getMoney();
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + e.getMessage() + LINE_STAMP);
			getProducts();
		}
	}

	private void getMoney() {
		String money = InputView.getMoney();
		try {
			PriceException.isValidPrice(money);
			int validMoney = Integer.parseInt(money);
			getOrder(validMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + INSERT_MONEY_PREFIX + e.getMessage() + LINE_STAMP);
			getMoney();
		}
	}

	private void getOrder(int money) {
		while (shouldChange(money)) {
		}
		returnChange();
	}

	private boolean shouldChange(int money) {
		int minProductPrice = vendingMachineService.getMinProductPrice();
		int productStock = vendingMachineService.getProductStock();
		if (minProductPrice > money
				|| productStock == 0) {
			return false;
		}
		return true;
	}

	private void returnChange() {

	}

}
