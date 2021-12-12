package vendingmachine.domain;

public class UserAccount {
	private static int account;

	public static void setUserAccount(int account) {
		UserAccount.account = account;
	}

	public static int getAccount() {
		return account;
	}

	public static void purchase(Catalog catalog) {
		account -= catalog.getPrice();
	}
}
