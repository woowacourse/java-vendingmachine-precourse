package vendingmachine.domain;

public class VendingMachine {

	private Changes changes;
	private Products products;

	public Changes getChanges() {
		return changes;
	}

	public Products getProducts() {
		return products;
	}

	public void createChanges(int inputMoney) {
		changes = new Changes(inputMoney);
		changes.createRandomCoin();
	}

	public void createProductList(String productInfo) {
		products = new Products();
		products.createProductList(productInfo);
	}

}
