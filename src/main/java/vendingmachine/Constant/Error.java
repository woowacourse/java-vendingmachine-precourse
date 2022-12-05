package vendingmachine.Constant;

public enum Error {
    INPUT_ALLOWED_ONLY_NUMBER("금액과 수량은 숫자만 입력이 가능합니다."),
    NOT_ALLOWED_SINGLE_DIGIT("10원 단위로만 입력이 가능합니다."),
    NOT_ALLOWED_MINUS_NUMBER("0원 이하의 금액은 입력할 수 없습니다."),
    NOT_ALLOWED_ORDER_ZERO("상품 주문시 0개 이하의 상품은 입력할 수 없습니다."),
    NOT_PROPER_ORDER_COMMAND("주문 형식이 잘못되었습니다. ex) [제품명,가격,수량];[제품명,가격,수량]"),
    NOT_EXIST_PRODUCT_NAME("존재하지 않는 제품명입니다."),
    SOLD_OUT_PRODUCT("해당제품은 품절입니다."),
    PRODUCT_NAME_BLANK("제품의 이름을 입력해주세요");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String toMessage() {
        String prefix = "[ERROR] ";
        return prefix + message;
    }
}
