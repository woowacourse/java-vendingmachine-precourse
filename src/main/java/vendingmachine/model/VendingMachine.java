package vendingmachine.model;

import java.util.List;

public class VendingMachine {

	private final List<CoinCase> coinCases;
	private final List<Product> products;
	private int remainInsertMoney;
	private static final int INITIAL_VALUE = 0;

	public VendingMachine(List<CoinCase> coinCases, List<Product> products, int insertMoney) {
		this.coinCases = coinCases;
		this.products = products;
		this.remainInsertMoney = insertMoney;
	}

	public int getRemainInsertMoney() {
		return remainInsertMoney;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void readyToSellProduct(String selectedProduct) {
		for (Product product : products) {
			if (product.getName().equals(selectedProduct)) {
				sellProduct(product);
			}
		}
	}

	private void sellProduct(Product product) {
		if (!product.isSoldOut()) {
			product.sellProduct();
			useMoneyToBuy(product);
		}
	}

	public boolean isReturnChangeCondition() {
		return getLowestProductPrice() > remainInsertMoney || isSoldOutAllProducts()
			|| !hasProductsUserCanBuy();
	}

	public Changes returnChanges() {
		return new Changes(coinCases, remainInsertMoney);
	}

	private boolean isSoldOutAllProducts() {
		return products.stream()
			.mapToInt(Product::getNumber)
			.max()
			.getAsInt() == INITIAL_VALUE;
	}

	private int getLowestProductPrice() {
		return products.stream()
			.mapToInt(Product::getPrice)
			.min()
			.getAsInt();
	}

	private boolean hasProductsUserCanBuy() {
		return products.stream()
			.filter(product -> product.getNumber() > INITIAL_VALUE)
			.anyMatch(product -> product.getPrice() <= remainInsertMoney);
	}

	private void useMoneyToBuy(Product product) {
		remainInsertMoney -= product.getPrice();
	}
}
