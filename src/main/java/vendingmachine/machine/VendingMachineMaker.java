package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.money.Changes;
import vendingmachine.product.ProductMapper;
import vendingmachine.product.ProductStorage;
import vendingmachine.product.ProductValidator;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineMaker {
	private Changes changes;
	private ProductStorage productStorage;
	private ProductMapper productMapper;
	private ProductValidator productValidator;

	public VendingMachineMaker() {
		this.changes = new Changes();
		this.productStorage = new ProductStorage();
		this.productMapper = new ProductMapper();
		this.productValidator = new ProductValidator();
	}

	public VendingMachine setUp() {
		setUpChanges();
		setUpProductStorage();
		return new VendingMachine(changes, productStorage);
	}

	private void setUpChanges() {
		InputView.printInitialMoneySettingMessage();
		requestInitialMoney();
	}

	private void requestInitialMoney() {
		try {
			changes.input(Console.readLine());
			changes.createRandomCoins();
			OutputView.printVendingMachineOwnCoins(changes.getCoins());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
			requestInitialMoney();
		}
	}

	private void setUpProductStorage() {
		InputView.printInitialProductSettingMessage();
		requestInitialProducts();
	}

	private void requestInitialProducts() {
		try {
			productStorage.storeProducts(Console.readLine(), productMapper, productValidator);
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
			requestInitialProducts();
		}
	}
}
