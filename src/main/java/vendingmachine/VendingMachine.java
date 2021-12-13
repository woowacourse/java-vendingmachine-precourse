package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();

	HashMap<Coin, Integer> coins = new HashMap<>();
	List<Item> items = new ArrayList<>();
	int userAmount;

	public VendingMachine() {
		int amount = getInputAmount();
		setCoins(amount);
		outputView.printCoinNumberMessage(coins);

		String inputItem = getInputItem();
		setItems(inputItem);

		getInputUserAmount();

		outputView.printUserAmount(userAmount);
	}

	private int getInputAmount() {
		String inputAmount;
		do {
			inputAmount = inputView.getInputAmount();
		} while (!InputAmountValidator.isValidated(inputAmount));
		return Integer.parseInt(inputAmount);
	}

	private void setCoins(int amount) {
		for (Coin coin : Coin.values()) {
			coins.put(coin, amount / coin.getAmount());
			amount = amount % coin.getAmount();
		}
	}

	private String getInputItem() {
		String inputItem;
		do {
			inputItem = inputView.getInputItem();
		} while(!InputItemValidator.isValidated(inputItem));
		return inputItem;
	}

	private void setItems(String inputItem) {
		List<String> itemStrings = new ArrayList<>();
		itemStrings = Arrays.asList(inputItem.split(";"));
		for (String itemString : itemStrings) {
			items.add(new Item(itemString));
		}
	}

	private void getInputUserAmount() {
		String inputUserAmount;
		do {
			inputUserAmount = inputView.getInputUserAmount();
		} while (!InputUserAmountValidator.isValidated(inputUserAmount));
		userAmount = Integer.parseInt(inputUserAmount);
	}
}
