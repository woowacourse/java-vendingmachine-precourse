package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
	private final CoinStore coinStore;
	private final ProductRepository productRepository = new ProductRepository();
	private int inputAmount = 0;

	public VendingMachine(int money) {
		coinStore = new CoinStore(money);
	}

	public String getHoldingAmountCoins() {
		return coinStore.toString();
	}

	public void insertProductListInProductRepository(List<String> productListString) {
		productRepository.createProducts(productListString);
	}

	public void insertUserInputAmount(int inputAmount) {
		this.inputAmount = inputAmount;
	}

	public int getInputAmount() {
		return inputAmount;
	}

	public void purchaseProduct(String productName) {
		inputAmount = productRepository.getChangeMoney(productName, inputAmount);
	}

	public boolean isPossibleRepurchase() {
		return (productRepository.isCheckStock() && productRepository.isWhetherPurchasePossible(inputAmount));
	}

	public String getChangeAmountToString() {
		return coinStore.changeCoinsToString(inputAmount);
	}
}
