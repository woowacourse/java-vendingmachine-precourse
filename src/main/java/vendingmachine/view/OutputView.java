package vendingmachine.view;

import vendingmachine.domain.Money;

public class OutputView {

	public static final String INPUT_MACHINE_MONEY_INSTRUCTION = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String ERROR_INSTRUCTION = "[ERROR] ";
	public static final String INPUT_PRODUCTS_INSTRUCTION = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String INPUT_USER_MONEY_INSTRUCTION = "투입 금액을 입력해 주세요.";
	public static final String INPUT_PURCHASE_PRODUCT_NAME_INSTRUCTION = "구매할 상품명을 입력해 주세요.";
	public static final String CURRENT_USER_MONEY = "투입 금액: %d원";
	public static final String RESULT_OF_RETURN_COINS = "잔돈";
	public static final String MACHINE_COIN_INSTRUCTION = "자판기가 보유한 동전";

	public static void printInputMachineMoneyInstruction() {
		System.out.println(INPUT_MACHINE_MONEY_INSTRUCTION);
	}

	public static void printError(String message) {
		System.out.println(ERROR_INSTRUCTION + message);
	}

	public static void printResultOfGenerateCoins(String resultOfgenerateCoins) {
		System.out.println(MACHINE_COIN_INSTRUCTION);
		System.out.println(resultOfgenerateCoins);
		System.out.println();
	}

	public static void printInputProductsInstruction() {
		System.out.println(INPUT_PRODUCTS_INSTRUCTION);
	}

	public static void printInputUserMoneyInstruction() {
		System.out.println(INPUT_USER_MONEY_INSTRUCTION);
	}

	public static void printResultOfInputUserMoney(int money) {
		System.out.println(money);
		System.out.println();
	}

	public static void printInputPurchaseProductNameInstruction() {
		System.out.println(INPUT_PURCHASE_PRODUCT_NAME_INSTRUCTION);
	}

	public static void printCurrentUserMoney(int currentUserMoney) {
		System.out.printf(CURRENT_USER_MONEY, currentUserMoney);
		System.out.println();
	}

	public static void printResultOfReturnCoins(String returnCoins) {
		System.out.println(RESULT_OF_RETURN_COINS);
		System.out.println(returnCoins);
	}
}
