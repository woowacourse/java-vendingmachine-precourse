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
			getInsertPrice();
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + e.getMessage() + LINE_STAMP);
			getProducts();
		}
	}

	private void getInsertPrice() {
		String userInsertPrice = InputView.getVendingMachineBalance();
		try {
			PriceException.isValidPrice(userInsertPrice);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + BALANCE_PRICE_PREFIX + e.getMessage() + LINE_STAMP);
			getInsertPrice();
		}
	}

}
