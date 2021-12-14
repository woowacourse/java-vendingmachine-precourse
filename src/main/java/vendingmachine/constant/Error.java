package vendingmachine.constant;

import static vendingmachine.constant.Constant.INFO_SPLITTER;
import static vendingmachine.constant.Constant.PRODUCT_SPLITTER;

public class Error {
    public static final String ERROR_INPUT_INT = "[ERROR] 양의 정수를 입력해주세요";
    public static final String ERROR_INPUT_PRODUCT_SPLITTER = "[ERROR] " + PRODUCT_SPLITTER +"를 사용하여 물건을 구분지어주세요";
    public static final String ERROR_INPUT_INFO_SPLITTER = "[ERROR] " + "[상품명, 가격, 수량]의 형태로 입력해주세요";
    public static final String ERROR_INPUT_NAME = "[ERROR] 이름을 꼭 써주세요" ;
    public static final String ERROR_INPUT_INT_BIGGER_0 = "[ERROR] 0 이상의 수를 입력해주세요";
}
