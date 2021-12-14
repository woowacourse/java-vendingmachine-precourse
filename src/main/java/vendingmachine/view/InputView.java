package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String VENDING_MACHINE_HAVING_MONEY_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String MERCHANDISE_NAME_PRICE_QUANTITY_INPUT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUT_MONEY_INPUT_MESSAGE = "투입 금액을 입력해 주세요";
	private static final String BUYING_MERCHANDISE_NAME = "구매할 상품명을 입력해 주세요.";

	public static String inputString() {
		return Console.readLine().trim();
	}

	public static String inputVendingMachineMoney() {
		System.out.println(VENDING_MACHINE_HAVING_MONEY_INPUT_MESSAGE);
		return inputString();
	}

	public static String inputMerchandiseInformation() {
		System.out.println();
		System.out.println(MERCHANDISE_NAME_PRICE_QUANTITY_INPUT_MESSAGE);
		return inputString();
	}

	public static String inputMoney() {
		System.out.println();
		System.out.println(INPUT_MONEY_INPUT_MESSAGE);
		return inputString();
	}

	public static String inputMerchandiseName() {
		System.out.println(BUYING_MERCHANDISE_NAME);
		return inputString();
	}
}
