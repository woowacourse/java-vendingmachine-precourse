package vendingmachine.view;

import java.util.Scanner;

import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;

import vendingmachine.domain.Product;

public class InputView {
	private static final String HOLDING_MONEY_GUIDE_MESSEAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String PRODUCT_INFO_GUIDE_MESSEEAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUT_MONEY_GUIDE_MESSEEAGE = "투입 금액을 입력해 주세요.";
	private static final String BUY_PRODUCT_GUIDE_MESSEEAGE = "구매할 상품명을 입력해 주세요.";
	private static final String PRODUCTS_DELIMITER = ";";
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TEN = 10;
	private static final int LIMITATION = (int)1e8;
	private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다.";
	private static final String LIMITATION_ERROR_MESSAGE = "[ERROR] 한계값을 넘는 수를 입력할 수 없습니다. (한계값: " + LIMITATION + ")";
	private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 반드시 음수가 아닌 숫자로 입력해주세요.";
	private static final String PRODUCT_INFO_DELIMITER = ",";
	private static final String PRODUCTS_DELIMITER_PREFIX = "[";
	private static final String PRODUCTS_DELIMITER_SUFFIX = "]";
	private static final String PRICE_DIVIDE_TEN_ERROR_MESSAGE = "[ERROR] 상품 가격은 10원으로 나누어 떨어져야합니다.";
	private static final String TWO_COMMAS = ",,";
	private static final String TWO_COMMAS_ERROR_MESSAGE = "[ERROR] 2개 이상의 쉼표가 연속으로 올 수 없습니다. ";
	private static final String INPUT_FORM_ERROR_MESSAGE = "[ERROR] 상품입력형식에 맞게 입력해주세요. 상품정보는 ;로 구분되고 각 상품정보는 [이름,가격,수량] 형식으로 입력해야 합니다. ";

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
		return validateProductNameAndPriceAndCnt();
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
			validateNumber(inputNumber);
			validateLowerThanLimitationNumber(inputNumber);
			validateNotNegativeNumber(inputNumber);
			return Integer.parseInt(inputNumber);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return validate();
		}
	}

	public void validateNumber(String inputNumber) {
		for (int i = 0; i < inputNumber.length(); i++) {
			if (!Character.isDigit(inputNumber.charAt(i))) {
				throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
			}
		}
	}

	public void validateLowerThanLimitationNumber(String inputNumber) {
		if (inputNumber.length() > 9) {
			throw new IllegalArgumentException(LIMITATION_ERROR_MESSAGE);
		}
	}

	public void validateNotNegativeNumber(String inputNumber) {
		if (Integer.parseInt(inputNumber) < ZERO) {
			throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
		}
	}

	public String[] validateProductNameAndPriceAndCnt() {
		try {
			String[] productNameAndPriceAndCnt = scanner.nextLine().split(PRODUCTS_DELIMITER);
			for (String productInfo : productNameAndPriceAndCnt) {
				validateProductInputForm(productInfo);
				productInfo = removeSquareBracket(productInfo);
				String[] product = productInfo.split(PRODUCT_INFO_DELIMITER);
				validatePrice(product[1]);
				validateProductCnt(product[2]);
			}
			return productNameAndPriceAndCnt;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return validateProductNameAndPriceAndCnt();
		}
	}

	public String removeSquareBracket(String product) {
		if (product.substring(ZERO, ONE).equals(PRODUCTS_DELIMITER_PREFIX)) {
			product = product.substring(ONE);
		}
		if (product.substring(product.length() - ONE).equals(PRODUCTS_DELIMITER_SUFFIX)) {
			product = product.substring(ZERO, product.length() - ONE);
		}
		return product;
	}

	public void validatePrice(String price) {
		validateNumber(price);
		validateLowerThanLimitationNumber(price);
		validateNotNegativeNumber(price);
		validateDivideTen(price);
	}

	public void validateDivideTen(String price) {
		if (Integer.parseInt(price) % TEN != ZERO) {
			throw new IllegalArgumentException(PRICE_DIVIDE_TEN_ERROR_MESSAGE);
		}
	}

	public void validateProductCnt(String productCnt) {
		validateNumber(productCnt);
		validateLowerThanLimitationNumber(productCnt);
		validateNotNegativeNumber(productCnt);
	}

	public void validateProductInputForm(String productInfo) {
		if (productInfo.contains(TWO_COMMAS)) {
			throw new IllegalArgumentException(TWO_COMMAS_ERROR_MESSAGE);
		}
		String[] product = productInfo.split(PRODUCT_INFO_DELIMITER);
		if (product.length != 3) {
			throw new IllegalArgumentException(INPUT_FORM_ERROR_MESSAGE);
		}
		if (!product[0].contains(PRODUCTS_DELIMITER_PREFIX) || !product[2].contains(PRODUCTS_DELIMITER_SUFFIX)) {
			throw new IllegalArgumentException(INPUT_FORM_ERROR_MESSAGE);
		}
	}
}
