package vendingmachine.views;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_CHANGES = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INPUT_ITEMS = "상품명과 가격, 수량을 입력해 주세요.";

	public static String inputChanges() {
		System.out.println(INPUT_CHANGES);
		return Console.readLine();
	}

	public static String inputItems() {
		System.out.println(INPUT_ITEMS);
		return Console.readLine();
	}
}
