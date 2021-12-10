package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class VendingMachine {

	private int deposit;
	private ProductList productList;
	private CoinList coinList;
	private Changes changes = new Changes();

	public VendingMachine(int deposit, ProductList productList, CoinList coinList) {
		this.deposit = deposit;
		this.productList = productList;
		this.coinList = coinList;
	}

	public ProductList getProductList() {
		return productList;
	}

	public int getDeposit() {
		return deposit;
	}

	public void subtractDeposit(int price) {
		this.deposit -= price;
	}

	public boolean isContinueToSell() {
		int minimumPrice = productList.getMinimumPrice();
		if (minimumPrice > deposit) {
			return false;
		}

		if (productList.isOutOfStock()) {
			return false;
		}

		return true;
	}

	public Changes createChanges() {
		LinkedHashMap<Coin, Integer> hashMap = coinList.getHashMap();
		for (Map.Entry<Coin, Integer> entry : hashMap.entrySet()) {
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

		coinList.subtractCoin(coin, availableNumberOfCoins - numberOfChange);
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
