package vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class VendingMachine {

	private Changes changes;
	private Products products;
	private InsertMoney insertMoney;

	public Changes getChanges() {
		return changes;
	}

	public Products getProducts() {
		return products;
	}

	public InsertMoney getInsertMoney() {
		return insertMoney;
	}

	public Map<Coin, Integer> returnChanges() {
		return changes.calculateRemainChanges(insertMoney.getCurrentMoney());
	}

	public void createChanges(int totalChanges) {
		changes = new Changes(totalChanges);
		changes.createRandomCoin();
	}

	public void createProductList(List<String> productInfoList) {
		products = new Products();
		products.createProductList(productInfoList);
	}

	public void createInsertMoney(int tempInsertMoney) {
		insertMoney = new InsertMoney(tempInsertMoney);
	}

	public void sellProduct(String productName) {
		if (products.checkStockAndSellProduct(productName)) {
			insertMoney.reduceMoney(products.getProductByName(productName).getPrice());
		}
	}

	public boolean isValidToBuyProductWithCurrentMoney() {
		return products.getMinPriceProduct() < insertMoney.getCurrentMoney();
	}

	public boolean isValidProductStock() {
		return products.checkStock(insertMoney.getCurrentMoney());
	}
}
