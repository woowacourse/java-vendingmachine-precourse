package vendingmachine.model;

public class InputMoneyModel {
	private static long inputMoney;

	public static void saveMoney(String string) {
		inputMoney = Long.parseLong(string);
	}

	public static void makeCoinFromInputMoney() {
		CoinModel.makeChangeCoins(inputMoney);
	}
}
