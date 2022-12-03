package vendingmachine.Constant;

public enum Error {
    INPUT_ALLOWED_ONLY_NUMBER("금액은 숫자만 입력이 가능합니다."),
    NOT_ALLOWED_SINGLE_DIGIT("10원 단위로만 입력이 가능합니다."),
    NOT_ALLOWED_MINUS_NUMBER("0원 이하의 금액은 입력할 수 없습니다."),

    NOT_PROPER_ORDER_COMMAND("주문 형식이 잘못되었습니다. ex) [제품명,가격,갯수];[제품명,가격,갯수]"),
    NOT_EXIST_PRODUCT_NAME("존재하지 않는 제품명입니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String toMessage() {
        String prefix = "[ERROR] ";
        return prefix + message;
    }
}
