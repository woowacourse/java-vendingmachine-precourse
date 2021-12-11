package vendingmachine.domain;

import java.util.List;

import vendingmachine.view.OutputView;

public class VendingMachine {
	private static final String SPLITTER_OF_PRODUCT_INFO = ",";
	private static final int PRODUCT_NAME_INDEX = 0;
	private static final int PRODUCT_COST_INDEX = 1;
	private static final int NUMBER_OF_PRODUCT_INDEX = 2;

	private final ProductRepository productRepository = new ProductRepository();
	private CoinBox coinBox;

	public void returnChanges(int amount) {
		OutputView.printChangesMessage();
		coinBox.returnChanges(amount);
	}

	public void sellProduct(String productName) {
		productRepository.sellProduct(productName);
	}

	public int getProductCost(String productName) {
		return productRepository.getProductCost(productName);
	}

	public boolean canTrade(int money) {
		return productRepository.canSellProduct(money);
	}

	public void addProducts(List<String> productList) {
		productList.forEach((productInfo) -> {
			String[] info = productInfo.split(SPLITTER_OF_PRODUCT_INFO);
			String productName = info[PRODUCT_NAME_INDEX];
			int productCost = Integer.parseInt(info[PRODUCT_COST_INDEX]);
			int numberOfProduct = Integer.parseInt(info[NUMBER_OF_PRODUCT_INDEX]);
			productRepository.addProduct(new Product(productName, productCost), numberOfProduct);
		});
	}

	public void showHoldingCoins() {
		OutputView.printHoldingCoinMessage();
		coinBox.showCoins();
	}

	public void setHoldingAmount(int amount) {
		coinBox = new CoinBox(amount);
	}
}
