package vendingmachine.job;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleDepositJob implements DepositJob {
	@Override
	public void execute() {
		System.out.println("투입 금액을 입력해 주세요.");
		String inputMoney = Console.readLine();
	}
}
