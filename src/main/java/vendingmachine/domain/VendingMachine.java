package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
	private static final String SPLITTER_OF_PRODUCT_INFO = ",";
	private static final int PRODUCT_NAME_INDEX = 0;
	private static final int PRODUCT_COST_INDEX = 1;
	private static final int NUMBER_OF_PRODUCT_INDEX = 2;

	private final ProductRepository productStorage = new ProductRepository();
	private CoinBox coinBox;

	public List<String> getChangeInfoListForCustomer(int changeAmount) {
		return coinBox.getChangeInfoListForCustomer(changeAmount);
	}

	public void setHoldingAmount(int amount) {
		coinBox = new CoinBox(amount);
	}

	public List<String> getHoldingCoinInfoList() {
		return coinBox.getCoinInfoList();
	}

	public int getProductCost(String productName) {
		return productStorage.getProductCost(productName);
	}

	public void addProducts(List<String> productList) {
		productList.forEach((productInfo) -> {
			String[] info = productInfo.split(SPLITTER_OF_PRODUCT_INFO);
			String productName = info[PRODUCT_NAME_INDEX];
			int productCost = Integer.parseInt(info[PRODUCT_COST_INDEX]);
			int numberOfProduct = Integer.parseInt(info[NUMBER_OF_PRODUCT_INDEX]);
			productStorage.addProduct(new Product(productName, productCost), numberOfProduct);
		});
	}

	public void sellProduct(String productName) {
		productStorage.sellProduct(productName);
	}

	public boolean canTrade(int money) {
		return productStorage.canSellProduct(money);
	}


}
