package vendingmachine.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.NumberValidator;

public class Input {
	static final String MSG_GET_MONEY_IN_MACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	static final String MSG_GET_INPUT_MONEY = "\n투입 금액을 입력해 주세요.";
	static final String MSG_GET_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";
	static final String PRODUCT_REGEX = ";";

	public static int moneyInMachine() {
		System.out.println(MSG_GET_MONEY_IN_MACHINE);
		String moneyInMachine = Console.readLine();
		NumberValidator.isInteger(moneyInMachine);
		return Integer.parseInt(moneyInMachine.trim());
	}

	public static List<String> productsInfo() {
		System.out.println(MSG_GET_MONEY_IN_MACHINE);
		String productsInfoGroup = Console.readLine();
		return Arrays.stream(productsInfoGroup.split(PRODUCT_REGEX))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public static int inputMoney() {
		System.out.println(MSG_GET_INPUT_MONEY);
		String inputMoney = Console.readLine();
		NumberValidator.isInteger(inputMoney);
		return Integer.parseInt(inputMoney.trim());
	}

	public static String buyingProductName() {
		System.out.println(MSG_GET_PRODUCT_NAME);
		String productName = Console.readLine();
		return productName.trim();
	}
}
