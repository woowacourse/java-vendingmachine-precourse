package vendingmachine.model;

import java.util.List;
import java.util.Map;

import exception.PriceException;
import exception.ProductException;
import vendingmachine.Coin;
import vendingmachine.controller.CoinController;

public class VendingMachine {
	private Map<Coin, Integer> coins;
	private List<Product> productList;
	private int balance;

	public void setBalance(String  rawBalance) throws IllegalArgumentException {
		int validPrice = PriceException.isValidPrice(rawBalance);
		this.balance = validPrice;
	}

	public int getBalance() {
		return balance;
	}

	public void setCoins() {
		this.coins = new CoinController().setCoinsByBalance(balance);
	}

	public Map<Coin, Integer> getCoins() {
		return coins;
	}

	public void setProductList(String userProducts) {
		List<Product> productList = ProductException.isValidProduct(userProducts);
		this.productList = productList;
	}
}
