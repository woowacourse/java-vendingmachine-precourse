package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.constant.Constant.*;
import static vendingmachine.domain.Coin.*;

import java.util.HashMap;

public class VendingMachine {
	private final HashMap<String, Integer> productPrice = new HashMap<>();
	private final HashMap<String, Integer> productStocks = new HashMap<>();
	private final HashMap<Integer, Integer> coinsOwned = new HashMap<>();

	public VendingMachine(int startMoney) {
		while (startMoney > 0) {
			int coinPicked = pickNumberInList(getCoinList());
			if (coinPicked <= startMoney) {
				coinsOwned.put(coinPicked, coinsOwned.get(coinPicked) + 1);
				startMoney -= coinPicked;
			}
		}
	}

	public void addProduct(String products) {
		for (String productPriceAndStock : products.split(DISTINGUISH_BETWEEN_PRODUCTS)) {
			String[] product = productPriceAndStock.split(DISTINGUISH_BETWEEN_PRODUCT_INFORMATION);
			// validateProduct(product);
			productPrice.put(product[NAME], Integer.parseInt(product[PRICE]));
			productStocks.put(product[NAME], Integer.parseInt(product[STOCKS]));
		}
	}

	private void sellProduct(String productName, int amountPaid) {
		if (!canSell(productName, amountPaid)) {
			return;
		}
		productStocks.put(productName, productStocks.get(productName) - 1);
		giveChange(amountPaid);
	}

	private boolean canSell(String productName, int amountPaid) {
		if (!isExistProductStocks(productName)) {
			return false;
		}
		return productPrice.get(productName) < amountPaid;
	}

	private boolean isExistProductStocks(String productName) {
		return productStocks.get(productName) >= MINIMUM_STOCKS;
	}

	private void giveChange(int amountPaid) {

	}

}
