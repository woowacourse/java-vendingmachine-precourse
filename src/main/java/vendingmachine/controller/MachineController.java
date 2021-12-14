package vendingmachine.controller;

import java.util.HashMap;
import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.OutputView;

public class MachineController {
	VendingMachine vendingMachine;

	public void work() {
		InputController inputController = new InputController();
		int holdingMoney = inputController.scanHoldingMoney();
		HashMap<Coin, Integer> coinCount = RandomCoinMaker.makeRandomCoin(holdingMoney);
		OutputView.printHoldingCoins(coinCount);
		List<Item> itemList = inputController.scanItemInform();
		int inputMoney = inputController.scanInputMoney();
		vendingMachine = new VendingMachine(holdingMoney, inputMoney, itemList, coinCount);
		buyItem();
		HashMap<Coin, Integer> change = vendingMachine.calculateChange();
		OutputView.printChange(change);
		vendingMachine.calculateCoinCount(change);
	}

	public void buyItem() {
		InputController inputController = new InputController();
		while (!vendingMachine.checkEmptyItemList() && vendingMachine.checkBuyingPossible()) {
			OutputView.printInputMoney(vendingMachine.inputMoney);
			int itemIndex = inputController.scanBuyingItem(vendingMachine.itemList);
			vendingMachine.updateItemList(itemIndex);
		}
		OutputView.printInputMoney(vendingMachine.inputMoney);
	}
}
