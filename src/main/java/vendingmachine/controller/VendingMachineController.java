package vendingmachine.controller;

import java.util.HashMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.validator.InputAmountValidator;
import vendingmachine.validator.InputBuyItemValidator;
import vendingmachine.validator.InputItemValidator;
import vendingmachine.validator.InputUserAmountValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	InputView inputView;
	OutputView outputView;
	VendingMachine vendingMachine;

	public VendingMachineController() {
		inputView = new InputView();
		outputView = new OutputView();
		vendingMachine = new VendingMachine();
	}

	public void ready() {
		int amount = getInputAmount();
		vendingMachine.setCoins(amount);

		outputView.printCoinNumberMessage(vendingMachine.getCoins());

		String inputItem = getInputItem();
		vendingMachine.setItems(inputItem);

		getInputUserAmount();
	}

	private int getInputAmount() {
		String inputAmount;
		do {
			inputAmount = inputView.getInputAmount();
		} while (!InputAmountValidator.isValidated(inputAmount));
		return Integer.parseInt(inputAmount);
	}

	private String getInputItem() {
		String inputItem;
		do {
			inputItem = inputView.getInputItem();
		} while (!InputItemValidator.isValidated(inputItem));
		return inputItem;
	}

	private void getInputUserAmount() {
		String inputUserAmount;
		do {
			inputUserAmount = inputView.getInputUserAmount();
		} while (!InputUserAmountValidator.isValidated(inputUserAmount));
		vendingMachine.setUserAmount(Integer.parseInt(inputUserAmount));
	}

	public void repeatBuyItem() {
		String buyItemName;
		do {
			outputView.printUserAmount(vendingMachine.getUserAmount());
			buyItemName = getInputBuyItem();
			buyItem(buyItemName);
		} while (couldRepeatBuyItem());
	}

	private String getInputBuyItem() {
		String inputBuyItem;
		do {
			inputBuyItem = inputView.getInputBuyItem();
		} while (!InputBuyItemValidator.isValidated(inputBuyItem, vendingMachine.getItems()));
		return inputBuyItem;
	}

	private void buyItem(String buyItemName) {
		final Item item = vendingMachine.getItems().get(buyItemName);
		item.reduceNumber();
		vendingMachine.reduceUserAmount(item.getPrice());
	}

	private boolean couldRepeatBuyItem() {
		return vendingMachine.checkRemainUserAmount() && vendingMachine.checkRemainItemNumber();
	}

	public void returnCoin() {
		outputView.printUserAmount(vendingMachine.getUserAmount());

		HashMap<Coin, Integer> returnCoins = new HashMap<>();
		getReturnCoin(returnCoins);

		outputView.printReturnCoin(returnCoins);
	}

	private void getReturnCoin(HashMap<Coin, Integer> returnCoins) {
		for (Coin coin : Coin.values()) {
			vendingMachine.calculateReturnCoin(returnCoins, coin);
		}
	}
}
