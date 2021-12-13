package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.validator.InputAmountValidator;
import vendingmachine.validator.InputBuyItemValidator;
import vendingmachine.validator.InputItemValidator;
import vendingmachine.validator.InputUserAmountValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
	private final static String SPLIT_REGEX = ",";
	private final static String INPUT_ITEM_SPLIT_REGEX = ";";
	private final static String REPLACE_TARGET_LEFT = "[";
	private final static String REPLACE_TARGET_RIGHT = "]";

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
			coins.put(coin, 0);
		}

		do {
			int randomCoinAmount = Randoms.pickNumberInList(Coin.getCoinValueList());
			if (amount - randomCoinAmount >= 0) {
				coins.computeIfPresent(Coin.valueOf(randomCoinAmount), (k, v) -> v + 1);
				amount -= randomCoinAmount;
			}
		} while (amount > 0);
	}

	private String getInputItem() {
		String inputItem;
		do {
			inputItem = inputView.getInputItem();
		} while (!InputItemValidator.isValidated(inputItem));
		return inputItem;
	}

	private void setItems(String inputItem) {
		String[] itemStrings = inputItem.split(INPUT_ITEM_SPLIT_REGEX);
		for (String itemString : itemStrings) {
			itemString = itemString.replace(REPLACE_TARGET_LEFT, "").replace(REPLACE_TARGET_RIGHT, "");
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
