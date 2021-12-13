package vendingmachine.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.NumberValidator;

public class Input {
	static final String MSG_GET_MONEY_IN_MACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	static final String MSG_GET_INPUT_MONEY = "투입 금액을 입력해 주세요.";

	public static int moneyInMachine() {
		System.out.println(MSG_GET_MONEY_IN_MACHINE);
		String moneyInMachine = Console.readLine();
		NumberValidator.isInteger(moneyInMachine);
		return Integer.parseInt(moneyInMachine);
	}

	public static List<String> productsInfo() {
		System.out.println(MSG_GET_MONEY_IN_MACHINE);
		String productsInfo = Console.readLine();
		return Arrays.stream(productsInfo.split(";"))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public static int inputMoney() {
		System.out.println(MSG_GET_INPUT_MONEY);
		String inputMoney = Console.readLine();
		NumberValidator.isInteger(inputMoney);
		return Integer.parseInt(inputMoney);
	}
}
