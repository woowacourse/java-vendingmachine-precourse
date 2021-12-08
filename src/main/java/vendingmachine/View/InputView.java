package vendingmachine.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String machineMoneyInput() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
		return Console.readLine();
	}
}
