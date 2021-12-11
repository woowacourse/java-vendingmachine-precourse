package vendingmachine.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	public Map<Integer, Integer> getChanges() {
		Map<Integer, Integer> change = new HashMap<>();
		for (CoinCase coinCase : coinCases) {
			if (remainInsertMoney == INITIAL_VALUE) {
				break;
			}
			int coinType = coinCase.getCoin().getAmount();
			int changeCount = coinCase.returnChange(remainInsertMoney / coinType);
			remainInsertMoney -= changeCount * coinType;
			change.put(coinType, changeCount);
		}
		return change;
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
		System.out.println(products.stream().map(Product::getNumber).collect(Collectors.toList()));
		return getLowestProductPrice() > remainInsertMoney || isSoldOut() || !hasProductsUserCanBuy();
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

	private boolean hasProductsUserCanBuy() {
		return products.stream()
			.filter(product -> product.getNumber() > INITIAL_VALUE)
			.filter(product -> product.getPrice() < remainInsertMoney)
			.count() != INITIAL_VALUE;
	}

	private void useMoneyToBuy(Product product) {
		remainInsertMoney -= product.getPrice();
	}
}
