package vendingmachine;

import vendingmachine.coin.Coins;
import vendingmachine.exception.VendingMachineException;
import vendingmachine.product.Products;

public class VendingMachine {
	private final Coins coins;
	private final Products products;
	private final Money insertMoney = Money.of(0);

	private VendingMachine(Coins coins, Products products) {
		validateEmpty(coins, products);
		this.coins = coins;
		this.products = products;
	}

	private void validateEmpty(Coins coins, Products products) {
		if(coins.isEmpty() || products.isEmpty()) {
			throw new VendingMachineException(Notification.VENDING_MACHINE_INITIALIZE_FAIL.getMessage());
		}
	}

	public static VendingMachine of(Coins coins, Products products) {
		return new VendingMachine(coins, products);
	}

	public void insert(Money money) {
		insertMoney.earn(money);
	}

	public Money getInsertMoney() {
		return insertMoney;
	}
}
