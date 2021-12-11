package vendingmachine.view;

import java.util.Scanner;

public class InputView {
	private static final String HOLDING_MONEY_GUIDE_MESSEAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String PRODUCT_INFO_GUIDE_MESSEEAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUT_MONEY_GUIDE_MESSEEAGE = "투입 금액을 입력해 주세요.";
	private static final String BUY_PRODUCT_GUIDE_MESSEEAGE = "구매할 상품명을 입력해 주세요.";
	private static final String PRODUCTS_DELIMITER = ";";

	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public String scanHoldingMoney() {
		System.out.println(HOLDING_MONEY_GUIDE_MESSEAGE);
		return scanner.nextLine();
	}

	public String[] scanProductNameAndPriceAndCnt() {
		System.out.println();
		System.out.println(PRODUCT_INFO_GUIDE_MESSEEAGE);
		final String products = scanner.nextLine().trim();
		return products.split(PRODUCTS_DELIMITER);
	}

	public String scanInputMoney() {
		System.out.println();
		System.out.println(INPUT_MONEY_GUIDE_MESSEEAGE);
		return scanner.nextLine();
	}

	public String scanBuyProductName() {
		System.out.println(BUY_PRODUCT_GUIDE_MESSEEAGE);
		return scanner.nextLine();
	}
}
