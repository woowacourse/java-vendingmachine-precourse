package vendingmachine;

import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Operation {

	private int inputMoney;
	private int holdingMoney;
	private Map<Coin, Integer> holdingCoins;
	private List<Item> holdingItemList;

	InputView inputView = new InputView();
	Coins coins = new Coins();

	public void operate() {
		holdingMoney = inputView.holdingMoneyInput();
		holdingCoins = coins.initializeCoins(holdingMoney);
		OutputView.printHoldingCoins(holdingCoins);

		holdingItemList = inputView.holdingItemsInput();
		inputMoney = inputView.inputMoneyInput();

		VendingMachine vendingMachine = VendingMachine.getVendingMachine(inputMoney, holdingItemList);

		buy(vendingMachine);
		returnChange(holdingCoins, vendingMachine);
	}

	private void buy(VendingMachine vendingMachine) {
		while (vendingMachine.isAvailableKeepBuyingAboutPrice() && vendingMachine.isAvailableKeepBuyingAboutStock()) {
			OutputView.printBalance(vendingMachine.inputMoney);
			String buyItem = inputView.buyItemInput(vendingMachine.holdingItemList, vendingMachine.inputMoney);
			vendingMachine.stockDeduct(buyItem);
			vendingMachine.inputMoneyDeduct(buyItem);
		}
	}

	private void returnChange(Map<Coin, Integer> holdingCoins, VendingMachine vendingMachine) {
		vendingMachine.calculateChangeCoins(holdingCoins);
		OutputView.printChangeCoins(vendingMachine.changeCoins);
	}
}