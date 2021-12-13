package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;

import vendingmachine.validator.InputAmountValidator;
import vendingmachine.validator.InputBuyItemValidator;
import vendingmachine.validator.InputItemValidator;
import vendingmachine.validator.InputUserAmountValidator;
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
		} while (!InputItemValidator.isValidated(inputItem));
		return inputItem;
	}

	private void setItems(String inputItem) {
		String[] itemStrings = inputItem.split(";");
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
		} while (couldRepeatBuyItem());
	}

	private String getInputBuyItem() {
		String inputBuyItem;
		do {
			inputBuyItem = inputView.getInputBuyItem();
		} while (!InputBuyItemValidator.isValidated(inputBuyItem, items));
		return inputBuyItem;
	}

	private void buyItem(String buyItemName) {
		final Item item = items.get(buyItemName);
		item.reduceNumber();
		userAmount -= item.getPrice();
	}

	private boolean couldRepeatBuyItem() {
		return checkRemainUserAmount() && checkRemainItemNumber();
	}

	private boolean checkRemainUserAmount() {
		Integer[] prices = items.values().stream()
			.map(Item::getPrice)
			.toArray(Integer[]::new);

		Arrays.sort(prices);

		return userAmount >= prices[0];
	}

	private boolean checkRemainItemNumber() {
		for (Item item : items.values()) {
			if (item.getNumber() != 0) {
				return true;
			}
		}
		return false;
	}

	public void returnCoin() {
		outputView.printUserAmount(userAmount);

		HashMap<Coin, Integer> returnCoins = new HashMap<>();
		getReturnCoin(returnCoins);

		outputView.printReturnCoin(returnCoins);
	}

	private void getReturnCoin(HashMap<Coin, Integer> returnCoins) {
		for (Coin coin : Coin.values()) {
			calculateReturnCoin(returnCoins, coin);
		}
	}

	private void calculateReturnCoin(HashMap<Coin, Integer> returnCoins, Coin coin) {
		int returnCoinNumber = 0;
		for (int i = 0; i < coins.get(coin); i++) {
			if (userAmount - coin.getAmount() >= 0) {
				returnCoinNumber++;
				userAmount -= coin.getAmount();
			}
		}
		if (returnCoinNumber > 0) {
			returnCoins.put(coin, returnCoinNumber);
		}
	}
}
