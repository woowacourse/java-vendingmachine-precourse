package vendingmachine.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import vendingmachine.coin.Coin;
import vendingmachine.product.Product;

public class Machine {
	private Map<Coin, Integer> coins;
	private List<Product> productList;
	private int money;

	public Machine() {
		initCoins();
		productList = new ArrayList<>();
		money = 0;
	}

	private void initCoins() {
		Map<Coin, Integer> coins = new HashMap<>();
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}
		this.coins = coins;
	}

	public Map<Coin, Integer> getCoins() {
		return coins;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public int getMoney() {
		return money;
	}

	public void insertMoney(int money) {
		this.money = money;
	}

	public boolean isRun() {
		if (!existStock() || !canBuyAny()) {
			return false;
		}
		return true;
	}

	public boolean existStock() {
		int stock = productList.stream()
			.filter(product -> product.getStock() > 0)
			.collect(Collectors.toList())
			.size();
		if (stock > 0) {
			return true;
		}
		return false;
	}

	public boolean canBuyAny() {
		int canBuy = productList.stream()
			.filter(product -> product.getPrice() <= money)
			.collect(Collectors.toList())
			.size();
		if (canBuy > 0) {
			return true;
		}
		return false;
	}

	public boolean isIn(String product) {
		List<String> productNames = productList.stream()
			.map(Product::getName).collect(Collectors.toList());
		for (String name : productNames) {
			if (name.equals(product)) {
				return true;
			}
		}
		return false;

	}

	public void buyProduct(Product product) {
		money -= product.getPrice();
	}

	public int giveChanges(Coin coin, int coinNum) {
		int coinAmount = coin.getAmount();
		int changesNum = money / coinAmount;
		if (changesNum > coinNum) {
			money -= (coinAmount * coinNum);
			coins.put(coin, 0);
			return coinNum;
		}
		money %= coinAmount;
		coins.put(coin, coinNum - (changesNum));
		return changesNum;
	}

}
