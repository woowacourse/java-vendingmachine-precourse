package vendingmachine.domain;

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

	public void createChanges(int totalChanges) {
		changes = new Changes(totalChanges);
		changes.createRandomCoin();
	}

	public void createProductList(String productInfo) {
		products = new Products();
		products.createProductList(productInfo);
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
