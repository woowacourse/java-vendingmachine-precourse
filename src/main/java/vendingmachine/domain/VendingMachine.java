package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {
	private final Coins coins;
	private final Products products;
	private int inputMoney;

	public VendingMachine (Coins coins, Products products, int inputMoney){
		this.coins = coins;
		this.products = products;
		this.inputMoney = inputMoney;
	}

	public int getInputMoney() {
		return inputMoney;
	}

	public boolean checkTermination() {
		return products.isLessThanMinPrice(inputMoney)
			|| products.getTotalAmount() == 0;
	}

	public void buy(String buyingProductName) {
		validateBuyingProductName(buyingProductName);
		Product product = products.getProductByName(buyingProductName);
		product.decreaseAmount();
		inputMoney = product.minusPrice(inputMoney);
	}

	public Map<Coin, Integer> giveChange() {
		if (!coins.isGreaterThanTotalMoney(inputMoney))	{
			return coins.getCoinsMap();
		}
		return coins.calculateChange(inputMoney);
	}

	private void validateBuyingProductName(String buyingProductName) {
		Product product = products.getProductByName(buyingProductName);
		if(product.getSmallerPrice(inputMoney) > inputMoney) {
			throw new IllegalArgumentException();
		}
		if (!product.isInStock()){
			throw new IllegalArgumentException();
		}
	}
}
