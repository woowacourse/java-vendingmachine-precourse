package vendingmachine.domain;

public class VendingMachine {

	private VendingMachineCoins vendingMachineCoins;
	private Products products;
	private Money userMoney;

	public VendingMachine(Money vendingMachineMoney) {
		this.vendingMachineCoins = createVendingMachineCoins(vendingMachineMoney);
	}

	private VendingMachineCoins createVendingMachineCoins(Money vendingMachineMoney) {
		return new VendingMachineCoins(vendingMachineMoney);
	}

	public VendingMachineCoins findCoins() {
		return vendingMachineCoins;
	}

	public void addProducts(Products products) {
		this.products = products;
	}

	public void inputMoney(Money money) {
		this.userMoney = money;
	}

	public boolean isPossibleToPurchaseProduct() {
		int minimumProductPrice = products.findMinimumProductPrice();
		return userMoney.isEnoughMoney(minimumProductPrice);
	}

	public int getUserMoney() {
		return userMoney.getUserMoney();
	}

	public void purchaseProduct(String purchaseProductName) {
		Product product = products.findProduct(purchaseProductName);
		product.validatePossibleToPurchase(product, userMoney.getUserMoney());
		product.reduceQuantity();
		userMoney.spendMoney(product.getPrice());
	}
}
