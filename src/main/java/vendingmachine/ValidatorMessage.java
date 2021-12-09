package vendingmachine;

public class ValidatorMessage {
    public static final String ERROR_MESSAGE = "[ERROR] ";

    public static final String NULL_PRODUCT_MESSAGE = "존재하지 않는 상품입니다.";
    public static final String NOT_ENOUGH_AMOUNT = "잔액이 부족합니다.";
    public static final String IS_POSITIVE_NUMBER_MESSAGE="숫자를 입력해주세요.";
    public static final String IS_NATURAL_NUMBER_MESSAGE="자연수로 입력해주세요.";

    public static final String AMOUNT_TENFOLD_NUMBER_MESSAGE="보유 금액은 0을 제외한 10의 배수여야 합니다.";

    public static final String PRODUCT_NAME_INVALID_MESSAGE="상품명에는 쉼표(,)나 괄호가 들어갈 수 없습니다.";
    public static final String PRODUCT_NAME_DUPLICATE_MESSAGE="중복된 상품명은 입력할 수 없습니다.";
    public static final String PRODUCT_INFO_INVALID_MESSAGE="상품 정보를 올바른 형식으로 입력해주세요.";
}
