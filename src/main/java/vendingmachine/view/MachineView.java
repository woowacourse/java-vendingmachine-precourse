package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class MachineView {
	private static final String INPUT_CHANGES_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public String inputChanges() {
		System.out.println(INPUT_CHANGES_MESSAGE);
		return Console.readLine();
	}
}
