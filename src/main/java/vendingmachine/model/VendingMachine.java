package vendingmachine.model;

import java.util.Map;

public class VendingMachine {

	private int deposit;
	private Products products;
	private Coins coins;
	private Changes changes = new Changes();

	public VendingMachine(int deposit, Products products, Coins coins) {
		this.deposit = deposit;
		this.products = products;
		this.coins = coins;
	}

	public Products getProductList() {
		return products;
	}

	public int getDeposit() {
		return deposit;
	}

	public void subtractDeposit(int price) {
		this.deposit -= price;
	}

	public boolean isContinueToSell() {
		int minimumPrice = products.getMinimumPrice();
		if (minimumPrice > deposit) {
			return false;
		}

		if (products.isOutOfStock()) {
			return false;
		}

		return true;
	}

	public Changes createChanges() {
		for (Map.Entry<Coin, Integer> entry : coins.getHashMap()) {
			if (deposit == 0) {
				break;
			}

			if (entry.getValue() == 0) {
				continue;
			}

			subtractFromCoinListAndAddChange(entry.getKey(), entry.getValue());
		}

		return changes;
	}

	private void subtractFromCoinListAndAddChange(Coin coin, int availableNumberOfCoins) {
		int numberOfChange = getNumberOfChange(coin, availableNumberOfCoins);
		if (numberOfChange == 0) {
			return;
		}

		coins.subtractCoin(coin, availableNumberOfCoins - numberOfChange);
		changes.addCoin(coin, numberOfChange);
	}

	private int getNumberOfChange(Coin coin, int maxNumberOfCoins) {
		for (int i = maxNumberOfCoins; i >= 0; i--) {
			if (deposit >= (i * coin.getAmount())) {
				deposit -= (i * coin.getAmount());
				return i;
			}
		}

		return 0;
	}

}
