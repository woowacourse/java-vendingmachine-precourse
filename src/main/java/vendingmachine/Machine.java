package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Machine {

	private static final String REQUEST_MSG_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	private int money;

	public void run() {
		inputMachineMoney();
	}

	public void inputMachineMoney() {
		String userInput;
		do {
			System.out.println(REQUEST_MSG_MACHINE_MONEY);
			userInput = Console.readLine();
		} while (!Validator.moneyCheck(userInput));
		this.money = Integer.parseInt(userInput);
	}

}
