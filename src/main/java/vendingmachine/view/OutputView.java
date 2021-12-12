package vendingmachine.view;

import vendingmachine.constant.Hint;
import vendingmachine.domain.Machine;
import vendingmachine.repository.DepositRepository;

public class OutputView {

	public static void printChanges(String changes) {
		System.out.println(Hint.CHANGE_IS.getHint());
		System.out.println(changes);
	}

	public static void printMoney(Machine machine) {
		System.out.printf(Hint.LEFT_MONEY.getHint(), machine.getUserMoney());
	}

	public static void printDeposits(DepositRepository depositRepository) {
		System.out.println(Hint.MACHINE_HAS.getHint());
		System.out.println(depositRepository.toString());
	}
}
