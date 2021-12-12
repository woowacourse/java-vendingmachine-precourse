package vendingmachine.SystemMessage;

public class ErrorMessage {
    public static final String WRONG_FORMAT_MESSAGE = "[ERROR] 잘못된 입력 형식입니다.";
    public static final String NOT_NUMBER_MESSAGE = "[ERROR] 금액은 숫자여야 합니다.";
    public static final String NOT_MULTIPLE_OF_10_MESSAGE = "[ERROR] 금액의 최소단위는 10원입니다.";
    public static final String NOT_POSITIVE_MESSAGE = "[ERROR] 금액과 상품개수는 음수일 수 없습니다.";
    public static final String LESS_THAN_100_MESSAGE = "[ERROR] 상품가격은 100원 이상이어야 합니다.";
    public static final String NO_SUCH_DRINK_MESSAGE = "[ERROR] 존재하지 없는 상품입니다.";
    public static final String SOLD_OUT_MESSAGE = "[ERROR] 매진된 상품입니다.";
}
