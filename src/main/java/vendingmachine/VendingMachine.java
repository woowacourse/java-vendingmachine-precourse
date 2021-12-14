package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private HashMap<Coin, Integer> coins = new HashMap<>();
	private HashMap<String, Product> products = new HashMap<>();
	private int inputAmount;

	VendingMachine() {
		int leftMoney = InputReceiver.getNumber(MoneyType.leftMoney);
		_makeCoins(leftMoney);
		this.products = InputReceiver.getProductInfo();
		this.inputAmount = InputReceiver.getNumber(MoneyType.inputAmount);
	}

	public HashMap<Coin, Integer> calculateChanges() {
		int tempBalance = this.inputAmount;
		HashMap<Coin, Integer> changes = new HashMap<>();

		for (Coin coin : Coin.values()) {
			int tempNumberOfCoin = tempBalance / coin.getAmount();

			if (tempNumberOfCoin >= this.coins.get(coin)) {
				tempBalance -= coin.getAmount() * this.coins.get(coin);
				changes.put(coin, this.coins.get(coin));
				this.coins.put(coin, 0);
			} else if (tempNumberOfCoin < this.coins.get(coin)) {
				tempBalance -= coin.getAmount() * tempNumberOfCoin;
				changes.put(coin, tempNumberOfCoin);
				this.coins.put(coin, this.coins.get(coin) - tempNumberOfCoin);
			}
		}
		return changes;
	}

	public void buy(String productName) {
		Product buyingProduct = products.get(productName);
		buyingProduct.reduceQuantity();
		this.inputAmount -= buyingProduct.getPrice();
	}

	public boolean canBuyAnything() {
		for (Product temp : products.values()) {
			if (temp.getQuantity() != 0 && temp.getPrice() < inputAmount) {
				return true;
			}
		}
		return false;
	}

	public boolean isLeftQuantity(String productName) {
		return products.get(productName).getQuantity() == 0;
	}

	public boolean isBuyableProduct(String productName) {
		return products.get(productName).getPrice() > this.inputAmount;
	}

	public int getInputAmount() {
		return this.inputAmount;
	}

	private void _makeCoins(int leftMoney) {
		for (Coin coin : Coin.values()) {
			this.coins.put(coin, 0);
		}

		int amountOfCoins = 0;

		while (leftMoney != amountOfCoins) {
			Coin key = Coin.getCoin(Randoms.pickNumberInList(Arrays.asList(500, 100, 50, 10)));
			int value = this.coins.get(key) + 1;
			this.coins.put(key, value);
			amountOfCoins += key.getAmount();
		}

		VendingMachinePrinter.printCurrentCoins(coins);
	}
}
