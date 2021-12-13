package vendingmachine.view;

import vendingmachine.constant.Hint;
import vendingmachine.repository.DepositRepository;

public class OutputView {

	public static void printChanges(String changes) {
		System.out.println(Hint.CHANGE_IS.getHint());
		System.out.println(changes);
	}

	public static void printMoney(int money) {
		System.out.printf(Hint.LEFT_MONEY.getHint(), money);
	}

	public static void printDeposits(String deposits) {
		System.out.println(Hint.MACHINE_HAS.getHint());
		System.out.println(deposits);
	}
}
