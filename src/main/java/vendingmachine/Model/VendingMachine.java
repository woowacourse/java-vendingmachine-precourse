package vendingmachine.Model;

import java.util.ArrayList;

public class VendingMachine {
	public CoinWallet machineCoins;
	public final Products products = new Products();
	public int userMoney;

	public void initCoins(int money) {
		machineCoins = new CoinWallet(money);
	}

	public void initProduct(ArrayList<Object[]> products) {
		for (Object[] values : products) {
			this.products.add(new Product(values));
		}
	}

	public void initUserMoney(int money) {
		userMoney = money;
	}

	public boolean isUserPoor() {
		return userMoney < products.getMinPrice();
	}

	public boolean allSoldOut() {
		return products.allSoldOut();
	}
}
