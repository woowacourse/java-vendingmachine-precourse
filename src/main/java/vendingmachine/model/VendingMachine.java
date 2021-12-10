package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class VendingMachine {

	private int deposit;
	private ProductList productList;
	private CoinList coinList;

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
		Changes changes = new Changes();
		LinkedHashMap<Coin, Integer> hashMap = coinList.getHashMap();
		for (Map.Entry<Coin, Integer> entry : hashMap.entrySet()) {
			Coin coin = entry.getKey();
			int availableNumberOfCoins = entry.getValue();

			if (deposit == 0) {
				break;
			}

			if (availableNumberOfCoins == 0) {
				continue;
			}

			int numberOfChange = getNumberOfChange(coin, availableNumberOfCoins);
			if (numberOfChange == 0) {
				continue;
			}

			changes.addCoin(coin, numberOfChange);
			coinList.subtractCoin(coin, availableNumberOfCoins - numberOfChange);
		}

		return changes;
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
