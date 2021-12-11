package vendingmachine.domain;

import java.util.List;

import vendingmachine.view.OutputView;

public class VendingMachine {
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
			String[] info = productInfo.split(",");
			productRepository.addProduct(new Product(info[0], Integer.parseInt(info[1])), Integer.parseInt(info[2]));
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
