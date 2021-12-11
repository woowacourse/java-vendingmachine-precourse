package vendingmachine.view;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Machine;

public class OutputView {
	public static final String CURRENT_MACHINE_COIN = "자판기가 보유한 동전";
	public static final String WON = "원";

	public static final String CURRENT_MONEY = "투입 금액: ";
	public static final String CHANGES = "잔돈";

	public void printMachineCoins(Machine machine) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n").append(CURRENT_MACHINE_COIN).append("\n");
		stringBuilder.append(machine.getCoinsList());
		System.out.println(stringBuilder);
	}

	public void printChanges(Machine machine, int inputMoney) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(CURRENT_MONEY + inputMoney + WON).append("\n");
		stringBuilder.append(CHANGES).append("\n");
		Coins changes = machine.calculateChange(inputMoney);
		stringBuilder.append(changes.toString());
		System.out.println(stringBuilder);
	}
}
