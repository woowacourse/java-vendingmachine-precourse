package vendingmachine.model;

public class InputMoneyModel {
	private static long inputMoney;
	private static long userMoney;

	public static void saveMoney(String string) {
		inputMoney = Long.parseLong(string);
	}

	public static void saveUserMoney(String string) {
		userMoney = Long.parseLong(string);
	}
	public static void makeCoinFromInputMoney() {
		CoinModel.makeChangeCoins(inputMoney);
	}
}
