package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.repository.ProductRepository;

public class VendingMachine {
	private LinkedHashMap<Coin, Integer> coinMap;
	private ProductRepository productRepository;
	private int balance;

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setCoinMap(LinkedHashMap<Coin, Integer> coinMap) {
		this.coinMap = coinMap;
	}

	public Map<Coin, Integer> getCoinMap() {
		return coinMap;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
}
