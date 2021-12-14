package vendingmachine.view;

import vendingmachine.utils.Constant;

public class OutputView {

	public static void print_line() {
		System.out.println();
	}

	public static void print_inputAmount() {
		System.out.println(Constant.INPUT_AMOUNT);
	}

	public static void print_vendingmachineCoin() {
		System.out.println(Constant.VENDINGMACHINE_COIN);
	}

	public static void print_coins(int coin, int count) { // coin원 - count개
		System.out.println(coin + Constant.UNIT_PAY + Constant.BETWEEN_UNIT + count + Constant.UNIT_COUNT);
	}

	public static void print_inputProduct() {
		System.out.println(Constant.INPUT_PRODUCTS);
	}

	public static void print_inputMoney() {
		System.out.println(Constant.INPUT_MONEY);
	}

	public static void print_money(int money) {// 투입 금액: 1000원
		System.out.println(Constant.INFORMATION_PAY + money + Constant.UNIT_PAY);
	}

	public static void print_input_ProduntName() {
		System.out.println(Constant.INPUT_PRODUCT_NAME);
	}

	public static void print_change() { // 잔돈
		System.out.println(Constant.RESULT_CHANGE);
	}

}
