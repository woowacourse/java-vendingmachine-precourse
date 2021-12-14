package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Machine {

	private static final String ERROR_MSG_PURCHASE_PRODUCT_NAME = "[ERROR] 해당하는 상품이 없습니다.";

	private int money;
	private HashMap<Coin, Integer> wallet;
	private List<Product> products;

	public Machine() {
		products = new ArrayList<>();
	}

	public int getMoney() {
		return money;
	}

	public void setMachineMoney(String input) {
		this.money = Integer.parseInt(input);
	}

	public void setWallet() {
		this.wallet = new HashMap<>();
		for (Coin coin : Arrays.stream(Coin.values()).collect(Collectors.toList())) {
			this.wallet.put(coin, 0);
		}
	}

	public void updateWallet(Coin coin) {
		this.wallet.put(coin, wallet.get(coin) + 1);
	}

	public int findCoinInWallet(Coin coin) {
		return this.wallet.get(coin);
	}

	public void makeProductsList(String[] input) {
		for (String productInfo : input) {
			this.products.add(new Product(Util.removeSquareBracket(productInfo)));
		}
	}

	public Product findProduct(String input) {
		for (Product product : products) {
			if (product.isThisName(input)) {
				return product;
			}
		}
		throw new IllegalArgumentException(ERROR_MSG_PURCHASE_PRODUCT_NAME);
	}

	public boolean minimumMoneyCheck(Customer customer) {
		for (Product product : products) {
			if (product.canSell(customer.getMoney())) {
				return true;
			}
		}
		return false;
	}

	public boolean hasCoin(Coin coin) {
		return this.wallet.get(coin) != 0;
	}

}
