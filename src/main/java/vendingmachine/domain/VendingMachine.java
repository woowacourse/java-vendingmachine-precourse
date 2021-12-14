package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {
	private static final HashMap<Integer, Integer> coins = new HashMap<>();
	private static final List<Product> products = new ArrayList<>();
	private final int changeAmount;

	public VendingMachine(int amount) {
		changeAmount = amount;
	}

	public void initProducts() {
		products.clear();
	}

	public int getChange() {
		return changeAmount;
	}

	public HashMap<Integer, Integer> getCoins() {
		return coins;
	}

	public List<Product> getProducts() {
		return products;
	}

}
