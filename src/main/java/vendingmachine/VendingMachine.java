package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
	private final static String SPLIT_REGEX = ",";

	InputView inputView = new InputView();
	OutputView outputView = new OutputView();

	HashMap<Coin, Integer> coins = new HashMap<>();
	HashMap<String, Item> items = new HashMap<>();
	int userAmount;

	public VendingMachine() {
		int amount = getInputAmount();
		setCoins(amount);
		outputView.printCoinNumberMessage(coins);

		String inputItem = getInputItem();
		setItems(inputItem);

		getInputUserAmount();
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
			itemString = itemString.replace("[", "").replace("]", "");
			String[] itemInfos = itemString.split(SPLIT_REGEX);
			items.put(itemInfos[0], new Item(itemInfos));
		}
	}

	private void getInputUserAmount() {
		String inputUserAmount;
		do {
			inputUserAmount = inputView.getInputUserAmount();
		} while (!InputUserAmountValidator.isValidated(inputUserAmount));
		userAmount = Integer.parseInt(inputUserAmount);
	}

	public void repeatBuyItem() {
		String buyItemName;
		do {
			outputView.printUserAmount(userAmount);
			buyItemName = getInputBuyItem();
			buyItem(buyItemName);
		} while(true);
	}

	private String getInputBuyItem() {
		String inputBuyItem;
		do {
			inputBuyItem = inputView.getInputBuyItem();
		} while(!InputBuyItemValidator.isValidated(inputBuyItem, items));
		return inputBuyItem;
	}

	private void buyItem(String buyItemName) {
		final Item item = items.get(buyItemName);
		item.reduceNumber();
		userAmount -= item.getPrice();
	}

	// private boolean couldRepeatBuyItem() {
	//
	// }
}
