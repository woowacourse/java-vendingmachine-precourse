package vendingmachine.model;

public class VendingMachine {

	Wallet wallet;
	ProductList productList;

	public VendingMachine() {
		wallet = new Wallet();
		productList = new ProductList();
	}

	public boolean isRemainProduct() {
		return productList.isRemainProduct();
	}

	public boolean canBuy(User user) {
	}
}
