package vendingmachine.controller;

import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.OutputView;

public class MachineController {
	public static final int ITEM_COUNT_ZERO = 0;

	VendingMachine vendingMachine = new VendingMachine();

	public void work() {
		InputController inputController = new InputController();
		vendingMachine.holdingMoney = inputController.scanHoldingMoney();
		vendingMachine.coinCount = RandomCoinMaker.makeRandomCoin(vendingMachine.holdingMoney);
		OutputView.printHoldingCoins(vendingMachine.coinCount);
		vendingMachine.itemList = inputController.scanItemInform();
		vendingMachine.inputMoney = inputController.scanInputMoney();
		buyItem();
	}

	public void buyItem() {
		InputController inputController = new InputController();
		while(!InputValidator.checkEmptyItemList(vendingMachine.itemList) && InputValidator.checkBuyingPossible(vendingMachine.itemList, vendingMachine.inputMoney)) {
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
			if (InputValidator.checkExcessMoney(vendingMachine.inputMoney, itemPrice)) {
				vendingMachine.minusInputMoney(itemPrice);
			}
		} catch (IllegalArgumentException e) {
			OutputView.printMoneyExcessError();
		}
	}
}
