package vendingmachine.controller;

import static vendingmachine.Constant.*;

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
		OutputView.printChange(vendingMachine.calculateChange());
	}

	public void buyItem() {
		InputController inputController = new InputController();
		while (!vendingMachine.checkEmptyItemList() && vendingMachine.checkBuyingPossible()) {
			OutputView.printInputMoney(vendingMachine.inputMoney);
			int itemIndex = inputController.scanBuyingItem(vendingMachine.itemList);
			updateItemList(itemIndex);
		}
		OutputView.printInputMoney(vendingMachine.inputMoney);
	}

	public void updateItemList(int index) {
		Item item = vendingMachine.itemList.get(index);
		item.minusCount();
		vendingMachine.itemList.set(index, item);
		calculateInputMoney(item.price);
		if (vendingMachine.itemList.get(index).count == ITEM_COUNT_ZERO) {
			vendingMachine.itemList.remove(index);
		}
	}

	public void calculateInputMoney(int itemPrice) {
		try {
			if (vendingMachine.checkExcessMoney(itemPrice)) {
				vendingMachine.minusInputMoney(itemPrice);
			}
		} catch (IllegalArgumentException e) {
			OutputView.printMoneyExcessError();
		}
	}
}
