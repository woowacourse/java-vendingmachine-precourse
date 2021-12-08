package vendingmachine.service;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.verification.Verification;

public class InputService {

	private static final String INPUT_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public int readMoney() {
		while (true) {
			try {
				System.out.println(INPUT_MONEY_MESSAGE);
				return Verification.ofMoney(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
