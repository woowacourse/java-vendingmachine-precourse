package vendingmachine.view;

import static vendingmachine.constant.OutputMessage.*;

import vendingmachine.domain.user.User;

public class OutputView {
	public static void printCoinCounter(String vendingMachineStatus) {
		System.out.println(COINS_HELD_BY_VENDING_MACHINE);
		System.out.println(vendingMachineStatus);
	}

	public static void printUserAmount(User user) {
		System.out.println();
		System.out.println(user);
	}

	public static void printChangeCoins(String changeStatus) {
		System.out.println(CHANGE);
		System.out.println(changeStatus);
	}
}
