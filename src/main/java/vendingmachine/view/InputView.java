package vendingmachine.view;

import java.util.Scanner;

import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;

public class InputView {
	private static final String HOLDING_MONEY_GUIDE_MESSEAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String PRODUCT_INFO_GUIDE_MESSEEAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUT_MONEY_GUIDE_MESSEEAGE = "투입 금액을 입력해 주세요.";
	private static final String BUY_PRODUCT_GUIDE_MESSEEAGE = "구매할 상품명을 입력해 주세요.";
	private static final String PRODUCTS_DELIMITER = ";";
	private static final int ZERO = 0;
	private static final int LIMITATION = (int) 2147483647;
	private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다.";
	private static final String LIMITATION_ERROR_MESSAGE = "[ERROR] 한계값을 넘는 수를 입력할 수 없습니다. (한계값: " + LIMITATION + ")";

	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public int scanHoldingMoney() {
		System.out.println(HOLDING_MONEY_GUIDE_MESSEAGE);
		return validate();
	}

	public String[] scanProductNameAndPriceAndCnt() {
		System.out.println();
		System.out.println(PRODUCT_INFO_GUIDE_MESSEEAGE);
		final String products = scanner.nextLine().trim();
		return products.split(PRODUCTS_DELIMITER);
	}

	public int scanInputMoney() {
		System.out.println();
		System.out.println(INPUT_MONEY_GUIDE_MESSEEAGE);
		return validate();
	}

	public String scanBuyProductName() {
		System.out.println(BUY_PRODUCT_GUIDE_MESSEEAGE);
		return scanner.nextLine();
	}

	public int validate() {
		try {
			String inputNumber = scanner.nextLine();
			validateNotNegativeNumber(inputNumber);
			return Integer.parseInt(inputNumber);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return validate();
		}
	}

	public void validateNotNegativeNumber(String inputNumber) {
		if (Integer.parseInt(inputNumber) < ZERO) {
			throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
		}
	}
}
