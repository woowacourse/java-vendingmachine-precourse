package vendingmachine.constant;

import static vendingmachine.constant.Constant.*;

public class Error {
	public static final String ERROR_INPUT_INT = "[ERROR] 양의 정수를 입력해주세요";
	public static final String ERROR_INPUT_INT_BIGGER_0 = "[ERROR] 0 이상의 수를 입력해주세요";
	public static final String ERROR_INPUT_INT_BIGGER_100 = "[ERROR] 가격은 100 이상의 수를 입력해주세요";
	public static final String ERROR_INPUT_INT_MULTIPLE_10 = "[ERROR] 10의 배수를 입력해주세요";
	public static final String ERROR_INPUT_BUY_PRODUCT = "[ERROR] 해당 물건을 살 돈이 없습니다";
	public static final String ERROR_INPUT_BUY_PRODUCT_STOCK = "[ERROR] 해당 물건의 재고가 없습니다";
	public static final String ERROR_INPUT_PRODUCT_SPLITTER = "[ERROR] " + PRODUCT_SPLITTER + "를 사용하여 물건을 구분지어주세요";
	public static final String ERROR_INPUT_INFO_SPLITTER = "[ERROR] " + "[상품명, 가격, 수량]의 형태로 입력해주세요";
	public static final String ERROR_INPUT_NAME = "[ERROR] 이름을 꼭 써주세요";
	public static final String ERROR_INPUT_BLANK = "[ERROR] 공백은 입력이 불가합니다";
	public static final String ERROR_INPUT_IS_PRODUCT = "[ERROR] 해당 물건이 없습니다";
}
