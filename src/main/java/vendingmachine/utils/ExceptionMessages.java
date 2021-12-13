package vendingmachine.utils;

public class ExceptionMessages {

    private static final String ERROR = "[ERROR] ";
    public static final String NOT_NUMBER_EXCEPTION = ERROR + "숫자를 입력하셔야 합니다.";
    public static final String NEGATIVE_NUMBER_EXCEPTION = ERROR + "음수를 입력하시면 안 됩니다.";
    public static final String HAS_ONES_NUMBER_EXCEPTION = ERROR + "1원 단위는 입력하시면 안 됩니다.";

    public static final String BLANK_INPUT_EXCEPTION = ERROR + "개별 상품 정보를 입력하지 않았습니다.";
    public static final String NOT_SURROUNDED_BY_BRACKETS_EXCEPTION = ERROR + "개별 상품 정보는 대괄호로 감싸여야 합니다.";
    public static final String INVALID_SEPARATORS_EXCEPTION = ERROR + "대괄호와 세미콜론 위치가 형식에 맞지 않습니다.";
    public static final String INVALID_COMMAS_EXCEPTION = ERROR + "개별 상품 정보의 세부 정보는 쉼표 2개를 기준으로 총 3가지여야 합니다.";
    public static final String BLANK_NAME_INPUT_EXCEPTION = ERROR + "상품명을 입력하지 않았습니다.";
    public static final String UNKNOWN_MERCHANDISE_NAME_EXCEPTION = ERROR + "존재하지 않는 상품명입니다.";
    public static final String SOLD_OUT_EXCEPTION = ERROR + "매진된 상품입니다.";
    public static final String DUPLICATE_MERCHANDISE_NAMES_EXCEPTION = ERROR + " 동일한 이름의 상품이 중복으로 존재하면 안 됩니다.";
    public static final String PRICE_NUMBER_NOT_NUMBER_EXCEPTION = ERROR + "상품의 가격과 수량은 숫자를 입력하셔야 합니다.";
    public static final String PRICE_NUMBER_LESS_THAN_HUNDRED_EXCEPTION = ERROR + "상품의 가격은 100원 이상의 값을 입력하셔야 합니다.";
    public static final String MERCHANDISE_NUMBER_NEGATIVE_NUMBER_EXCEPTION = ERROR + "상품의 수량으로 음수를 입력하시면 안 됩니다.";
}
