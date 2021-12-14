package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import vendingmachine.domain.enumclass.Coin;
import vendingmachine.utils.CoinUtil;
import vendingmachine.validation.GlobalValidation;
import vendingmachine.validation.validator.InputProductValidator;

public class VendingMachine {

	private Map<Integer, Integer> coinMap;
	private List<Product> products;
	private int inputCost;

	public VendingMachine() {
		this.coinMap = new TreeMap<>(Collections.reverseOrder());
		this.products = new ArrayList<>();
		this.inputCost = 0;

		coinMap.put(Coin.COIN_500.getAmount(), 0);
		coinMap.put(Coin.COIN_100.getAmount(), 0);
		coinMap.put(Coin.COIN_50.getAmount(), 0);
		coinMap.put(Coin.COIN_10.getAmount(), 0);
	}

	public void initProducts() {
		products = new ArrayList<>();
	}

	public void makeCoinInCoinMap(int money) {
		while (money > 0) {
			money = compareRandomCoinAndMoney(money, CoinUtil.generateRandomCoin());
		}
	}

	private int compareRandomCoinAndMoney(int money, int randomCoin) {
		if (randomCoin <= money) {
			addCoin(randomCoin);
			money -= randomCoin;
		}

		return money;
	}

	public int getSumCoinAmount() {
		return coinMap.keySet().stream().mapToInt(key -> key * coinMap.get(key)).sum();
	}

	public void addCoin(int coin) {
		coinMap.put(coin, coinMap.get(coin) + 1);
	}

	public void addProducts(String[] productList) {
		for (String rowProduct : productList) {
			String[] product = rowProduct.split(",");
			InputProductValidator.validateProduct(product, products);

			addProduct(
				new Product(product[0], Integer.parseInt(product[1]), Integer.parseInt(product[2])));
		}
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void subtractInputCostAndProductAmount(String productName) {
		Product rightProduct = products.stream().filter(product -> productName.equals(product.getName())).collect(
			Collectors.toList()).get(0);

		subtractInputCost(rightProduct);
		rightProduct.subtractAmount();
	}

	private void subtractInputCost(Product product) {
		GlobalValidation.validateProductAmountIsZero(product.getAmount());

		if (product.CanInputCostSubtract(inputCost)) {
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

	public int compareInputCostAndCoinToGetChange() {
		if (inputCost < getSumCoinAmount()) {
			return inputCost;
		}

		return getSumCoinAmount();
	}

	public void canInputCostSet(int inputCost) {
		if (this.inputCost == 0) {
			this.inputCost = inputCost;
		}
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
}
