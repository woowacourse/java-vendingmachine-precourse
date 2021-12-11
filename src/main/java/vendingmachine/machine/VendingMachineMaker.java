package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.product.ProductMapper;
import vendingmachine.product.ProductStorage;
import vendingmachine.product.ProductValidator;
import vendingmachine.slot.ChangeSlot;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineMaker {
	private ChangeSlot changeSlot;
	private ProductStorage productStorage;
	private ProductMapper productMapper;
	private ProductValidator productValidator;

	public VendingMachineMaker() {
		this.changeSlot = new ChangeSlot();
		this.productStorage = new ProductStorage();
		this.productMapper = new ProductMapper();
		this.productValidator = new ProductValidator();
	}

	public VendingMachine setUp() {
		setUpChangeSlot();
		setUpProductStorage();
		return new VendingMachine(changeSlot, productStorage);
	}

	private void setUpChangeSlot() {
		InputView.printInitialMoneySettingMessage();
		requestInitialMoney();
	}

	private void requestInitialMoney() {
		try {
			changeSlot.input(Console.readLine());
			OutputView.printVendingMachineOwnCoins(changeSlot.createRandomCoins());
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
