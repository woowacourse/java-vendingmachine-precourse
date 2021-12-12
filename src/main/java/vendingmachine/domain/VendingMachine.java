package vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class VendingMachine {

	private Changes changes;
	private Products products;
	private InputMoney inputMoney;

	public Changes getChanges() {
		return changes;
	}

	public Products getProducts() {
		return products;
	}

	public InputMoney getInputMoney() {
		return inputMoney;
	}

	public Map<Coin, Integer> returnChanges() {
		return changes.calculateRemainChanges(inputMoney.getCurrentMoney());
	}

	public void createChanges(int totalChanges) {
		changes = new Changes(totalChanges);
		changes.createRandomCoin();
	}

	public void createProductList(List<String> productInfoList) {
		products = new Products();
		products.createProductList(productInfoList);
	}

	public void createInputMoney(int tempInputMoney) {
		inputMoney = new InputMoney(tempInputMoney);
	}

	public boolean sellProduct(String productName) {
		if (products.checkStockAndSellProduct(productName)) {
			inputMoney.reduceMoney(products.getProductByName(productName).getPrice());
			return true;
		}
		return false;
	}

}
