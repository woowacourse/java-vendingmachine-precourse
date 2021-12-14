package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.Name;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
	public void runMachine() {
		VendingMachine vendingMachine = loadVendingMachine();
		insertMachineMoney(vendingMachine);
		insertProducts(vendingMachine);
		insertUserMoney(vendingMachine);
		saleProcess(vendingMachine);
		returnUserCoins(vendingMachine);
	}

	private void saleProcess(VendingMachine vendingMachine) {
		boolean canSale = vendingMachine.canSale();
		while (canSale) {
			OutputView.printCurrentUserMoney(vendingMachine.toCurrentUserMoney());
			OutputView.printInputPurchaseProductNameInstruction();
			vendingMachine.sale(Name.of(InputView.getProductName()));
			canSale = vendingMachine.canSale();
		}
	}

	private VendingMachine loadVendingMachine() {
		VendingMachine vendingMachine = VendingMachine.getInstance();
		vendingMachine.init();
		return vendingMachine;
	}

	private void insertMachineMoney(VendingMachine vendingMachine) {
		OutputView.printInputMachineMoneyInstruction();
		vendingMachine.insertMachineMoney(Money.of(InputView.getMoney()));
		OutputView.printResultOfGenerateCoins(vendingMachine.generateCoins());
	}

	private void insertProducts(VendingMachine vendingMachine) {
		OutputView.printInputProductsInstruction();
		vendingMachine.insertProducts(Products.from(InputView.getProducts()));
	}

	private void insertUserMoney(VendingMachine vendingMachine) {
		OutputView.printInputUserMoneyInstruction();
		vendingMachine.insertUserMoney(Money.of(InputView.getMoney()));
		OutputView.printResultOfInputUserMoney(vendingMachine.toCurrentUserMoney());
	}

	private void returnUserCoins(VendingMachine vendingMachine) {
		OutputView.printCurrentUserMoney(vendingMachine.toCurrentUserMoney());
		OutputView.printResultOfReturnCoins(vendingMachine.returnCoins());
	}
}
