package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.Name;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
	public void runMachine() {
		VendingMachine vendingMachine = VendingMachine.getInstance();
		vendingMachine.init();

		OutputView.printInputMachineMoneyInstruction();
		Money machineMoney = Money.of(InputView.getMoney());
		vendingMachine.insertMachineMoney(machineMoney);
		OutputView.printResultOfGenerateCoins(vendingMachine.generateCoins());

		OutputView.printInputProductsInstruction();
		Products products = Products.from(InputView.getProducts());
		vendingMachine.insertProducts(products);

		OutputView.printInputUserMoneyInstruction();
		Money userMoney = Money.of(InputView.getMoney());
		OutputView.printResultOfInputUserMoney(userMoney);
		vendingMachine.insertUserMoney(userMoney);

		boolean canSale = vendingMachine.canSale();
		while (canSale) {
			OutputView.printCurrentUserMoney(vendingMachine.toCurrentUserMoney());
			OutputView.printInputPurchaseProductNameInstruction();
			Name wantedProductName = Name.of(InputView.getProductName());
			vendingMachine.sale(wantedProductName);

			canSale = vendingMachine.canSale();
		}

		OutputView.printCurrentUserMoney(vendingMachine.toCurrentUserMoney());
		String returnCoins = vendingMachine.returnCoins();
		OutputView.printResultOfReturnCoins(returnCoins);

	}
}
