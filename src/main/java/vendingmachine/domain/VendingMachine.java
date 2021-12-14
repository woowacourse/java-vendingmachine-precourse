package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
	public static final String INPUT_AMOUNT_PREFIX = "투입 금액: ";
	public static final String INPUT_AMOUNT_UNIT = "원";
	private final CoinStore coinStore;
	private final ProductRepository productRepository = new ProductRepository();
	private int inputAmount = 0;

	public VendingMachine(int money) {
		coinStore = new CoinStore(money);
	}

	public String getHoldingAmountCoinsToString() {
		return coinStore.toString();
	}

	public void insertProductListInProductRepository(List<String> productListString) {
		productRepository.createProducts(productListString);
	}

	public void addInputAmount(int money) {
		this.inputAmount += money;
	}

	public void purchaseProduct(String productName) {
		inputAmount = productRepository.getChangeMoney(productName, inputAmount);
	}

	public boolean isPossiblePurchase() {
		return productRepository.isCheckStock() && productRepository.isWhetherPurchasePossible(inputAmount);
	}

	public String getChangeAmountToString() {
		return coinStore.changeCoinsToString(inputAmount);
	}

	@Override
	public String toString() {
		return INPUT_AMOUNT_PREFIX + inputAmount + INPUT_AMOUNT_UNIT;
	}
}
