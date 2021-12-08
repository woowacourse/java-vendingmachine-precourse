package vendingmachine.view;

import static vendingmachine.validator.MoneyValidator.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public int getMoneyOfVendingMachine() {
		String input = "";

		boolean isValid = false;
		while (!isValid) {
			input = Console.readLine();
			try {
				isValid = isValidMoney(input);
			} catch (IllegalArgumentException exception) {
				// TODO: 2021/12/08 에러 메시지 출력
			}
		}

		return Integer.parseInt(input);
	}

}
