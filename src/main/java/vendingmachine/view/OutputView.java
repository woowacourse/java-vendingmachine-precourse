package vendingmachine.view;

import vendingmachine.domain.Money;

public class OutputView {

	public static final String INPUT_MACHINE_MONEY_INSTRUCTION = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String ERROR_INSTRUCTION = "[ERROR] ";
	public static final String INPUT_PRODUCTS_INSTRUCTION = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String INPUT_USER_MONEY_INSTRUCTION = "투입 금액을 입력해 주세요.";
	public static final String INPUT_PURCHASE_PRODUCT_NAME_INSTRUCTION = "구매할 상품명을 입력해 주세요.";

	public static void printInputMachineMoneyInstruction() {
		System.out.println(INPUT_MACHINE_MONEY_INSTRUCTION);
	}

	public static void printError(String message) {
		System.out.println(ERROR_INSTRUCTION + message);
	}

	public static void printResultOfGenerateCoins(String resultOfgenerateCoins) {
		System.out.println(resultOfgenerateCoins);
		System.out.println();
	}

	public static void printInputProductsInstruction() {
		System.out.println(INPUT_PRODUCTS_INSTRUCTION);
	}

	public static void printInputUserMoneyInstruction() {
		System.out.println(INPUT_USER_MONEY_INSTRUCTION);
	}

	public static void printResultOfInputUserMoney(Money money) {
		System.out.println(money.toInt());
		System.out.println();
	}

	public static void printInputPurchaseProductNameInstruction() {
		System.out.println(INPUT_PURCHASE_PRODUCT_NAME_INSTRUCTION);
	}
}
