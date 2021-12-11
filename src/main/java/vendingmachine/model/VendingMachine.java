package vendingmachine.model;

import java.util.List;
import java.util.Map;

public class VendingMachine {
	private Map<Coin, Integer> coinMap;
	private List<Product> productList;
	private int balance;

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setCoinMap(Map<Coin, Integer> coinMap) {
		this.coinMap = coinMap;
	}

	public Map<Coin, Integer> getCoinMap() {
		return coinMap;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Product> getProductList() {
		return productList;
	}
}
