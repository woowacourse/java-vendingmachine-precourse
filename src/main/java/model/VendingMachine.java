package model;

import java.util.List;
import java.util.Map;

public class VendingMachine {
	private CoinBox coinBox;
	private ProductBox productBox;
	private InsertedMoneyBox insertedMoneyBox;

	public void makeCoinBox(int change) {
		coinBox = new CoinBox(change);
	}

	public void makeProductBox(List<String> products) {
		productBox = new ProductBox(products);
	}

	public void makeInsertedMoneyBox(int insertedMoney) {
		insertedMoneyBox = new InsertedMoneyBox(insertedMoney);
	}

	public List<Integer> giveCountOfEachCoins() {
		return coinBox.getCountOfEachCoins();
	}

	public List<Integer> givePriceOfEachCoins() {
		return coinBox.getPriceOfEachCoins();
	}

	public int giveInsertedMoney() {
		return insertedMoneyBox.getMoney();
	}

	public boolean isAllProductSoldOut() {
		return !productBox.hasProduct();
	}

	public boolean hasEnoughMoneyToBuyProduct() {
		return insertedMoneyBox.hasEnoughMoney(productBox.getMinimumProductPrice());
	}

	public void sellProduct(String productName) {
		productBox.sellProduct(productName);
		insertedMoneyBox.reduceMoney(productBox.giveSoldProductPrice(productName));
	}

	public Map<Integer, Integer> giveChangeCoins() {
		return coinBox.getChangeCoins(insertedMoneyBox.getMoney());
	}
}
