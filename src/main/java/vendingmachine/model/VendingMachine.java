package vendingmachine.model;

import java.util.List;

import exception.PriceException;
import vendingmachine.Coin;

public class VendingMachine {
	private List<Coin> coins;
	private ProductRepository productRepository;
	private int balance;

	public void setBalance(String  rawBalance) throws IllegalArgumentException {
		int validPrice = PriceException.isValidPrice(rawBalance);
		this.balance = validPrice;
	}
}
