package vendingmachine.view;

import vendingmachine.constant.Constant;
import vendingmachine.constant.Message;
import vendingmachine.domain.VendingMachineCoins;
import vendingmachine.type.Coin;

public class OutputView {

	public static void printInputVendingMachineCoin() {
		System.out.println(Message.INPUT_VENDING_MACHINE_COIN);
	}

	public static void printVendingMachineCoins(VendingMachineCoins vendingMachineCoins) {
		printNewLine();
		System.out.println(Message.VENDING_MACHINE_COINS);
		for (Coin coin : vendingMachineCoins.getKeys()) {
			System.out.println(
				coin.getAmount() + Constant.WON + Constant.DASH + vendingMachineCoins.getAmount(coin) + Constant.EA);
		}
	}

	private static void printNewLine() {
		System.out.println();
	}

	public static void printInputProduct() {
		printNewLine();
		System.out.println(Message.INPUT_PRODUCT);
	}

	public static void printException(Exception exception) {
		System.out.println(Message.ERROR + exception.getMessage());
	}

	public static void printInputMoney() {
		printNewLine();
		System.out.println(Message.INPUT_MONEY);
	}

	public static void printCurrentUserMoney(int userMoney) {
		printNewLine();
		System.out.println(Message.CHECK_CURRENT_USER_MONEY + userMoney + Constant.WON);
	}

	public static void printInputPurchaseProduct() {
		System.out.println(Message.INPUT_PURCHASE_PRODUCT);
	}

	public static void printChange(VendingMachineCoins changeCoins) {
		System.out.println(Constant.RETURN_COINS);
		for (Coin coin : changeCoins.getKeys()) {
			if (changeCoins.hasCoin(coin)) {
				System.out.println(
					coin.getAmount() + Constant.WON + Constant.DASH + changeCoins.getAmount(coin) + Constant.EA);
			}
		}
	}
}
