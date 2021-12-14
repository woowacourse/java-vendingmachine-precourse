package vendingmachine;

import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
	public static void main(String[] args) {
		int inputMoney;
		int holdingMoney;
		Map<Coin, Integer> holdingCoins;
		List<Item> holdingItemList;

		InputView inputView = new InputView();
		Coins coins = new Coins();

		holdingMoney = inputView.holdingMoneyInput();
		holdingCoins = coins.initializeCoins(holdingMoney);

		OutputView.printHoldingCoins(holdingCoins);

		holdingItemList = inputView.holdingItemsInput();
		inputMoney = inputView.inputMoneyInput();
		VendingMachine vendingMachine = VendingMachine.getVendingMachine(inputMoney, holdingItemList);

		while (vendingMachine.isAvailableKeepBuyingAboutPrice() && vendingMachine.isAvailableKeepBuyingAboutStock()) {
			OutputView.printBalance(vendingMachine.inputMoney);
			String buyItem = inputView.buyItemInput(vendingMachine.holdingItemList, vendingMachine.inputMoney);
			vendingMachine.stockDeduct(buyItem);
			vendingMachine.inputMoneyDeduct(buyItem);
		}
		vendingMachine.calculateChangeCoins(holdingCoins);
		OutputView.printChangeCoins(vendingMachine.changeCoins);
	}
}
