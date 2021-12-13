package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String REQUEST_CHANGES_UI = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String REQUEST_PRODUCTS_UI = "상품명과 가격, 수량을 입력해 주세요.";

	public static String requestChanges() {
		System.out.println(REQUEST_CHANGES_UI);
		return Console.readLine();
	}

	public static String requestProducts() {
		System.out.println(REQUEST_PRODUCTS_UI);
		return Console.readLine();
	}
}
