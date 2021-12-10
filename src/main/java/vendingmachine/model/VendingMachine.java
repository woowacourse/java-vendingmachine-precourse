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
		if (coinList.getTotalMoney() <= deposit) {
			return new Changes(coinList);
		}

		Changes changes = new Changes();
		LinkedHashMap<Coin, Integer> hashMap = coinList.getHashMap();
		for (Map.Entry<Coin, Integer> entry : hashMap.entrySet()) {
			if (deposit == 0) {
				break;
			}

			if (entry.getValue() == 0) {
				continue;
			}

			int numberOfCoins = 0;
			for (int i = entry.getValue(); i >= 0; i--) {
				if (deposit >= (i * entry.getKey().getAmount())) {
					numberOfCoins = i;
					deposit -= (i * entry.getKey().getAmount());
					break;
				}
			}

			changes.addCoin(entry.getKey(), numberOfCoins);
			coinList.subtractCoin(entry.getKey(), entry.getValue() - numberOfCoins);
		}

		return changes;
	}

}
