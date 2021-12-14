package vendingmachine.repository;

import vendingmachine.domain.Catalog;
import vendingmachine.domain.Coin;

public class UserAccount {
	private static int account;

	public static void setUserAccount(int account) {
		UserAccount.account = account;
	}

	public static int getAccount() {
		return account;
	}

	public static void purchase(int price) {
		account -= price;
	}

	public static boolean canBuyAnyCatalog() {
		return CatalogRepository.isExistCheaperThan(account);
	}

	public static boolean canBuy(Catalog catalog) {
		return catalog.isCheaperThan(account);
	}

	public static int divideByCoinUnit(Coin coin) {
		return account / coin.getAmount();
	}

	public static void subtract(int money) {
		account -= money;
	}

	@Override
	public String toString() {
		return String.valueOf(account);
	}
}
