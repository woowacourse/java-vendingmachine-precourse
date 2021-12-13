package vendingmachine.util;

public enum ErrorMessage {
    ERROR_NOT_EXIST_SQUARE_BUCKET_LAST_STRING("[ERROR] 닫는 대괄호로 끝나야 합니다."),
    ERROR_CANNOT_CONTAIN_SPACE("[ERROR] 상품 입력에 공백 문자를 포함할 수 없습니다."),
    ERROR_NOT_CORRECT_FORMAT("[ERROR] \"[상품명,가격,수량];[상품명,가격,수량];[..\" 형식이어야 합니다."),
    ERROR_CANNOT_DUPLICATE("[ERROR] 상품 이름은 중복될 수 없습니다."),

    ERROR_NOT_NUMBER("[ERROR] 금액은 숫자여야 합니다."),
    ERROR_OUT_OF_RANGE_AMOUNT("[ERROR] 금액은 100원 이상이어야 합니다."),
    ERROR_CANNOT_DIVIDE_BY_TEN("[ERROR] 금액은 10원 단위여야 합니다."),
    ERROR_OUT_OF_RANGE_INVENTORY("[ERROR] 수량은 1개 이상이어야 합니다."),

    ERROR_NOT_EXIST_MERCHANDISE_NAME("[ERROR] 해당 상품은 존재하지 않습니다."),
    ERROR_SOLD_OUT_MERCHANDISE("[ERROR] 해당 상품은 품절되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
