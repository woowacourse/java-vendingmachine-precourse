package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

import static vendingmachine.view.Print.*;
import static vendingmachine.service.VendingMachineManagement.*;
import static vendingmachine.Error.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;

public class VendingMachine {
	private HashMap<Coin, Integer> changes = new HashMap<>(Coin.values().length);
	private HashMap<Product, Integer> products = new HashMap<>();
	private int money;

	private static final int INITIAL_COIN = 0;
	private static final int ADD_COUNT_OF_COIN = 1;
	private static final int SUBTRACT_COUNT_OF_PRODUCT = 1;
	private static final int PRODUCT_NOT_EXIST = 0;

	public VendingMachine() {
		Coin[] coins = Coin.values();

		for (Coin coin : coins) {
			this.changes.put(coin, INITIAL_COIN);
		}
	}

	public int getMoney() {
		return this.money;
	}

	public boolean isDuplicatedName(String name) {
		for (Entry<Product, Integer> product : this.products.entrySet()) {
			String existName = product.getKey().getName();

			if (existName.equals(name)) {
				return true;
			}
		}
		return false;
	}

	public void setChanges(int money) {
		List<Integer> amountOfCoins = Coin.getAmountOfCoins();

		// TODO: 로직 수정하기
		while (money > 0) {
			int amount = pickNumberInList(amountOfCoins);

			if (money < amount) {
				continue;
			}
			Coin coin = Coin.getCoinAsAmount(amount);
			addCountOfCoin(coin);
			money -= amount;
		}
	}

	private void addCountOfCoin(Coin coin) {
		this.changes.put(coin, this.changes.get(coin) + ADD_COUNT_OF_COIN);
	}

	public void noticeCountOfCoins() {
		Coin[] coins = Coin.values();

		for (Coin coin : coins) {
			int amount = Coin.getAmountOfCoin(coin);
			int count = changes.get(coin);

			printCountOfCoins(amount, count);
		}
	}

	public void setProducts(List<HashMap<String, String>> products) {
		for (HashMap<String, String> product : products) {
			setProduct(product);
		}
	}

	private void setProduct(HashMap<String, String> productMap) {
		int price = Integer.parseInt(productMap.get(PRODUCT_PRICE));
		int quantity = Integer.parseInt(productMap.get(PRODUCT_QUANTITY));
		Product product = new Product(productMap.get(PRODUCT_NAME), price);

		products.put(product, quantity);
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isPurchase() {
		if (isLowerMinimumPrice()) {
			return false;
		}
		return true;
	}

	private boolean isLowerMinimumPrice() {
		int minimumPrice = getMinimumPrice();
		return this.money < minimumPrice;
	}

	private int getMinimumPrice() {
		ArrayList<Integer> priceList = getPriceList();
		if (priceList.size() == PRODUCT_NOT_EXIST) {
			return PRODUCT_NOT_EXIST;
		}

		int minimumPrice = priceList.get(0);
		for (Integer price : priceList) {
			if (price < minimumPrice) {
				minimumPrice = price;
			}
		}
		return minimumPrice;
	}

	private ArrayList<Integer> getPriceList() {
		ArrayList<Integer> priceList = new ArrayList<>();

		for (Entry<Product, Integer> product : products.entrySet()) {
			if (product.getValue() == PRODUCT_NOT_EXIST) {
				continue;
			}
			int price = product.getKey().getPrice();
			priceList.add(price);
		}
		return priceList;
	}

	public void buy(String name) {
		Product selectedProduct = getProduct(name);

		if (selectedProduct == null) {
			printNotice(NOT_EXIST_PRODUCT_NAME);
			return;
		}
		if (!isPurchaseNowProduct(selectedProduct)) {
			return;
		}

		subtractProduct(selectedProduct);
		subtractMoney(selectedProduct.getPrice());
	}

	private Product getProduct(String name) {
		for (Entry<Product, Integer> product : products.entrySet()) {
			Product nowProduct = product.getKey();
			if (nowProduct.getName().equals(name)) {
				return nowProduct;
			}
		}
		return null;
	}

	private boolean isPurchaseNowProduct(Product product) {
		if (isLowerProductPrice(product)) {
			printNotice(LOWER_MONEY);
			return false;
		}
		if (!isProductExist(product)) {
			printNotice(NOT_EXIST_PRODUCT);
			return false;
		}
		return true;
	}

	private boolean isLowerProductPrice(Product product) {
		return this.money < product.getPrice();
	}

	private boolean isProductExist(Product product) {
		return products.get(product) > PRODUCT_NOT_EXIST;
	}

	private void subtractProduct(Product product) {
		products.put(product, products.get(product) - SUBTRACT_COUNT_OF_PRODUCT);
	}

	private void subtractMoney(int money) {
		this.money -= money;
	}

	public void returnChanges() {
		Coin[] coins = Coin.values();

		for (Coin coin : coins) {
			int amount = Coin.getAmountOfCoin(coin);
			int count = getReturnCountOfCoin(coin);

			if (count == INITIAL_COIN) {
				continue;
			}
			printCountOfCoins(amount, count);
		}
	}

	private int getReturnCountOfCoin(Coin coin) {
		int amount = Coin.getAmountOfCoin(coin);
		int count = INITIAL_COIN;

		if (money < amount) {
			return count;
		}
		count = changes.get(coin);
		subtractMoney(amount * count);

		return count;
	}
}
