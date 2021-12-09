package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
	private CoinStore coinStore;
	private ProductRepository productRepository =  new ProductRepository();
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
}
