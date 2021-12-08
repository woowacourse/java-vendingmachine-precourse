package vendingmachine.model;

import java.util.List;

import vendingmachine.Coin;

public class VendingMachine {
	private List<Coin> coins;
	private ProductRepository productRepository;
	private int balance;
}
