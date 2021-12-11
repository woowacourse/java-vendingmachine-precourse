package vendingmachine.input;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.message.Ask;
import vendingmachine.util.Validator;

public class CustomerInput {
	public int getInsertedMoney() {
		System.out.println(Ask.INSERT_MONEY);
		String input = Console.readLine();
		validateMoneyInput(input);
		return Integer.parseInt(input);
	}

	private void validateMoneyInput(String input) {
		Validator.onlyNums(input);
	}
}
