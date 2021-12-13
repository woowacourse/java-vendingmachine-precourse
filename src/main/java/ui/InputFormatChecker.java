package ui;

import java.util.regex.Pattern;

public class InputFormatChecker {
	private static final String NUMBER_REGULAR_EXPRESSION = "^[0-9]+0$";
	private static final String PRODUCT_SPEC_REGULAR_EXPRESSION
		= "^\\[[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]+,[0-9]+0,[0-9]+\\](;\\[[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]+,[0-9]+0,[0-9]+\\])*$";
	private static final String FORMAT_ERROR_MESSAGE_ONLY_NUMBER
		= "[ERROR] 숫자만 입력해 주세요. 또한 가격을 10원 단위로 입력했는지 확인해 주세요.\n";
	private static final String FORMAT_ERROR_MESSAGE_PRODUCT_SPEC
		= "[ERROR] [상품명,가격,수량];[상품명,가격,수량] 형식으로 입력해 주세요. 또한 가격을 10원 단위로 입력했는지 확인해 주세요.\n";

	private boolean checkFormat(String regularExpression, String target) {
		if (Pattern.matches(regularExpression, target)) {
			return true;
		}
		return false;
	}

	protected boolean checkMoneyFormat(String money) throws IllegalArgumentException {
		if (checkFormat(NUMBER_REGULAR_EXPRESSION, money)) {
			return true;
		}
		throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE_ONLY_NUMBER);
	}

	protected boolean checkProductSpecFormat(String products) throws IllegalArgumentException {
		if (checkFormat(PRODUCT_SPEC_REGULAR_EXPRESSION, products)) {
			return true;
		}
		throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE_PRODUCT_SPEC);
	}
}
