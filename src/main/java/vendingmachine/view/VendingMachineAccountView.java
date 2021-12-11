package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachineAccount;

public class VendingMachineAccountView {
	private static final String INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	private static final VendingMachineAccount vendingMachineAccount = new VendingMachineAccount();

	public static void printInputGuide() {
		System.out.println(INPUT_MESSAGE);
	}

	public static void printCoinList() {
		for (Coin coin : Coin.values()) {
			Integer coinCount = vendingMachineAccount.getCoinCount(coin);
			System.out.println(coin.getAmount() + "원 - " + coinCount + "개");
		}
	}
}
