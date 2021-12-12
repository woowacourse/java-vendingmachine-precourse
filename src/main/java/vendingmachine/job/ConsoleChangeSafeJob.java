package vendingmachine.job;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleChangeSafeJob implements ChangeSafeJob {
	@Override
	public void execute() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
		String inputMoney = Console.readLine();
		if ("-1".equals(inputMoney)) {
			System.out.println("[ERROR] 잘못된 입력입니다.");
			return ;
		}
		System.out.println("자판기가 보유한 동전\n"
			+ "500원 - 0개\n"
			+ "100원 - 4개\n"
			+ "50원 - 1개\n"
			+ "10원 - 0개");
	}
}
