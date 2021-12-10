package vendingmachine.model;

import java.util.List;

public class VendingMachine {

	private final List<CoinCase> coinsCase;
	private final List<Product> products;
	private final int insertMoney;
	private int remain;

	public VendingMachine(List<CoinCase> coinCases, List<Product> products, int insertMoney) {
		this.coinsCase = coinCases;
		this.products = products;
		this.insertMoney = insertMoney;
		this.remain = insertMoney;
	}

	public int getRemain() {
		return remain;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void readyToSellProduct(String selectedProduct) {
		for (Product product : products) {
			if (product.getName().equals(selectedProduct)) {
				product.sellProduct();
				useMoneyToBuy(product);
			}
		}
	}

	public boolean isReturnChangeCondition() {
		if (getLowestProductPrice() > remain || isSoldOut()) {
			return true;
		}
		return false;
	}

	private boolean isSoldOut() {
		return products.stream()
			.mapToInt(Product::getNumber)
			.max()
			.getAsInt() == 0;
	}

	private int getLowestProductPrice() {
		return products.stream()
			.mapToInt(Product::getPrice)
			.min()
			.getAsInt();
	}

	private void useMoneyToBuy(Product product) {
		remain -= product.getPrice();
	}
}
