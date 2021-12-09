package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private List<Integer> coins;
	private List<Product> products = new ArrayList<>();

	public void setUpInitialVendingMachine() {
		InputView.showInitialMoneySettingMessage();
		InitialMoney initialMoney = new InitialMoney();
		requestInitialMoney(initialMoney);
		OutputView.printVendingMachineOwnCoins(coins);

		InputView.printInitialProductSettingMessage();
		ProductFactory productFactory = new ProductFactory();
		products = productFactory.createProducts(Console.readLine());
	}

	private void requestInitialMoney(InitialMoney initialMoney) {
		try {
			initialMoney.input(Console.readLine());
			coins = initialMoney.createRandomCoins();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
			requestInitialMoney(initialMoney);
		}
	}
}
