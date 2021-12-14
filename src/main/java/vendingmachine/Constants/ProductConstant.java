package vendingmachine.Constants;

public class ProductConstant {

    public static int MINIMUM_PRICE = 100;
    public static int NAME_INDEX = 0;
    public static int PRICE_INDEX = 1;
    public static int STOCK_INDEX = 2;

    public static String NAME_ERROR_MESSAGE = "[ERROR] 상품 이름은 한글 혹은 알파벳으로만 이루어져야 합니다.";
    public static String PRICE_NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 상품 가격은 숫자여야 합니다.";
    public static String DIVIDE_TEN_ERROR_MESSAGE = "[ERROR] 상품 가격은 10으로 나누어 떨어져야 합니다.";
    public static String MINIMUM_PRICE_ERROR_MESSAGE = "[ERROR] 상품 가격은 100원 이상부터 시작해야합니다.";
    public static String STOCK_NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 재고 갯수는 숫자여야 합니다.";

    public static String NAME_REGEX = "^[ㄱ-ㅎ가-힣a-zA-Z]*$";
    public static String NUMERIC_REGEX = "[0-9]+";
    public static String LEFT_SQUARE_BRACKET = "\\[";
    public static String RIGHT_SQUARE_BRACKET = "]";
    public static String SEMI_COLON = ";";
    public static String BLANK = "";
    public static String COMMA = ",";


}
