package vendingmachine.domain;

public class VendingMachine {
	private final Coins coins;
	private final Products products;
	private int inputMoney;

	public VendingMachine (Coins coins, Products products, int inputMoney){
		this.coins = coins;
		this.products = products;
		this.inputMoney = inputMoney;
	}

	public boolean checkTermination() {
		return products.isLessThanMinPrice(inputMoney)
			|| products.getTotalAmount() == 0;
	}

	private void validateBuyingProductName(String buyingProductName) {
		Product product = products.getProductByName(buyingProductName);
		if(product.getSmallerPrice(inputMoney) > inputMoney) {
			throw new IllegalArgumentException();
		}
		if (product.isInStock()){
			throw new IllegalArgumentException();
		}
	}
}
