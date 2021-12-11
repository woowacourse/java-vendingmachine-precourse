package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import vendingmachine.domain.enumclass.Coin;
import vendingmachine.validation.Validation;

public class VendingMachine {

	private Map<Integer, Integer> coinMap;
	private List<Product> products;
	private int inputCost;

	public VendingMachine() {
		this.coinMap = new TreeMap<>(Collections.reverseOrder());
		this.products = new ArrayList<>();
		coinMap.put(Coin.COIN_500.getAmount(), 0);
		coinMap.put(Coin.COIN_100.getAmount(), 0);
		coinMap.put(Coin.COIN_50.getAmount(), 0);
		coinMap.put(Coin.COIN_10.getAmount(), 0);
	}

	public void initProducts() {
		products = new ArrayList<>();
	}

	public int getSumCoinAmount() {
		int sum = 0;
		for (Integer i : coinMap.keySet()) {
			sum += i * coinMap.get(i);
		}
		return sum;
	}

	public void addCoin(int coin) {
		coinMap.put(coin, coinMap.get(coin) + 1);
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void subtractInputCostAndProductAmount(String productName) {
		for (Product product : products) {
			if (productName.equals(product.getName())) {
				subtractInputCost(product);
				product.subtractAmount();
				break;
			}
		}
	}

	private void subtractInputCost(Product product) {
		Validation.validateProductAmountIsZero(product);

		if (inputCost - product.getPrice() >= 0) {
			inputCost -= product.getPrice();
		}
	}

	public boolean checkGetChange() {
		if (compareLowPriceAndInputCost()) {
			return true;
		}
		return false;
	}

	public boolean compareLowPriceAndInputCost() {
		Collections.sort(products);
		if (products.get(0).getPrice() <= inputCost && products.get(0).getAmount() > 0) {
			return false;
		}

		return true;
	}

/*	public boolean checkAllProductAmount() {
		for (Product product : products) {
			if (product.getAmount() > 0) {
				return false;
			}
		}
		return true;
	}*/

	public int compareInputCostAndCoinToChange() {
		if (inputCost < getSumCoinAmount()) {
			return inputCost;
		}

		return getSumCoinAmount();
	}

	public Map<Integer, Integer> getCoinMap() {
		return coinMap;
	}

	public int getInputCost() {
		return inputCost;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setInputCost(int inputCost) {
		this.inputCost = inputCost;
	}
}
