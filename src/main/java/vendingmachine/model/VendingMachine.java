package vendingmachine.model;

import java.util.List;

public class VendingMachine {

	private final CoinCase coinCase;
	private final List<Product> products;
	private static int remainInsertMoney;
	private static final int INITIAL_VALUE = 0;

	public VendingMachine(CoinCase coinCase, List<Product> products, int insertMoney) {
		this.coinCase = coinCase;
		this.products = products;
		remainInsertMoney = insertMoney;
	}

	public int getRemainInsertMoney() {
		return remainInsertMoney;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void readyToSellProduct(String selectedProduct) {
		products.stream()
			.filter(product -> product.getName().equals(selectedProduct))
			.forEach(VendingMachine::sellProduct);
	}

	private static void sellProduct(Product product) {
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
		return new Changes(coinCase, remainInsertMoney);
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

	private static void useMoneyToBuy(Product product) {
		remainInsertMoney -= product.getPrice();
	}
}
