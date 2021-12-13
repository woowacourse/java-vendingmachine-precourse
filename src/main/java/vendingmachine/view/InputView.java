package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

	private static final String INPUT_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String ASK_DEPOSIT_AMOUNT_MESSAGE = "투입 금액을 입력해 주세요.";
	private static final String PRODUCT_REGISTRATION_REQUEST = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String ASK_PRODUCT_WANT_TO_BUY = "구매할 상품명을 입력해 주세요.";

	public String getMoneyInput() {
		System.out.println(INPUT_MONEY_MESSAGE);
		return readLine();
	}

	public String getDepositInput() {
		System.out.println("\n" + ASK_DEPOSIT_AMOUNT_MESSAGE);
		return readLine();
	}

	public String getRawProductsInput() {
		System.out.println(PRODUCT_REGISTRATION_REQUEST);
		return readLine();
	}

	public String getProductWantToBuy() {
		System.out.println(ASK_PRODUCT_WANT_TO_BUY);
		return readLine();
	}
}
