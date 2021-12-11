package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.constant.Constant.*;
import static vendingmachine.domain.Coin.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class VendingMachine {
	private final HashMap<String, Integer> productPrice = new HashMap<>();
	private final HashMap<String, Integer> productStocks = new HashMap<>();
	private final LinkedHashMap<Integer, Integer> coinsOwned = new LinkedHashMap<>();

	public VendingMachine(int startMoney) {
		for (int coin : getCoinList()) {
			coinsOwned.put(coin, INITIAL_VALUE);
		}
		while (startMoney > INITIAL_VALUE) {
			int coinPicked = pickNumberInList(getCoinList());
			if (coinPicked <= startMoney) {
				coinsOwned.put(coinPicked, coinsOwned.get(coinPicked) + 1);
				startMoney -= coinPicked;
			}
		}
	}

	public void addProduct(String products) {
		products = products.replaceAll(LEFT_SQUARE_BRACKETS, "").replaceAll(RIGHT_SQUARE_BRACKETS, "");
		for (String productPriceAndStock : products.split(DISTINGUISH_BETWEEN_PRODUCTS)) {
			String[] product = productPriceAndStock.split(DISTINGUISH_BETWEEN_PRODUCT_INFORMATION);
			// validateProduct(product);
			productPrice.put(product[NAME], Integer.parseInt(product[PRICE]));
			productStocks.put(product[NAME], Integer.parseInt(product[STOCKS]));
		}
	}

	public int getProduct(String productName, int paidMoney) {
		if (!canSell(productName, paidMoney)) {
			throw new IllegalArgumentException(NO_STOCKS_MESSAGE);
		}
		productStocks.put(productName, productStocks.get(productName) - 1);
		return paidMoney - productPrice.get(productName) + calculateMinimumChange(
			paidMoney - productPrice.get(productName));
	}

	private boolean canSell(String productName, int amountPaid) {
		if (!isExistProductStocks(productName)) {
			return false;
		}
		return productPrice.get(productName) <= amountPaid;
	}

	private boolean isExistProductStocks(String productName) {
		return productStocks.get(productName) >= MINIMUM_STOCKS;
	}

	private int calculateMinimumChange(int changeCoin) {
		for (int coin : coinsOwned.keySet()) {
			int coinNumberToPay = Math.min(coinsOwned.get(coin), changeCoin / coin);
			coinsOwned.put(coin, coinsOwned.get(coin)
				- coinNumberToPay);
			changeCoin -= coin * coinNumberToPay;
		}
		return changeCoin;
	}

	private boolean canGiveChange(int remainingChange) {
		for (int coin : coinsOwned.keySet()) {
			remainingChange -= coin * Math.min(coinsOwned.get(coin), remainingChange / coin);
		}
		return remainingChange == 0;
	}

	public LinkedHashMap<Integer, Integer> getCoinsOwned() {
		return coinsOwned;
	}

	public int getNeedMinimumMoney() {
		return Collections.min(productPrice.values());
	}
}
