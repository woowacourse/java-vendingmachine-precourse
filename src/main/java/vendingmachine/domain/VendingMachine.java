package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
	private CoinStore coinStore;
	private ProductRepository productRepository =  new ProductRepository();

	public VendingMachine(int money) {
		coinStore = new CoinStore(money);
	}

	public String getHoldingAmountCoins() {
		return coinStore.toString();
	}

	public void insertProductListInProductRepository(List<String> productListString) {
		productRepository.createProducts(productListString);
	}
}
