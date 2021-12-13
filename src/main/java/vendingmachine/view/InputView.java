package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public String enterMachineMoney() {
		System.out.println(INPUT_MACHINE_MONEY);
		String machineMoney = Console.readLine();

		return machineMoney;
	}
}
