package vendingmachine.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.Validator;

public class Input {
	static final String MSG_GET_MONEY_IN_MACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static int getMoneyInMachine() {
		String moneyInVendingMachine;
		do {
			System.out.println(MSG_GET_MONEY_IN_MACHINE);
			moneyInVendingMachine = Console.readLine();
		} while (Validator.isValidMoneyInMachine(moneyInVendingMachine));
		return Integer.parseInt(moneyInVendingMachine);
	}

	public static List<String> getProductsInfo() {
		System.out.println(MSG_GET_MONEY_IN_MACHINE);
		String productsInfo = Console.readLine();
		return Arrays.stream(productsInfo.split(";"))
			.map(String::trim)
			.collect(Collectors.toList());
	}
}
