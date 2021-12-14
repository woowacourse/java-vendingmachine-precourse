package vendingmachine.util.validator.error;

public enum Error {
    FOUND_NULL("[ERROR] null이 입력되었습니다."),
    FOUND_BLANK("[ERROR] 공백이 입력되었습니다."),
    IS_NOT_INTEGER("[ERROR] 숫자만 입력되어야합니다."),
    OUT_OF_RANGE("[ERROR] 입력 범위를 초과하였습니다."),
    IS_NEGATIVE_INTEGER("[ERROR] 음수가 입력되었습니다."),
    IS_NOT_MULTIPLY_BY_TEN("[ERROR] 10의 배수로 입력되어야합니다."),
    INPUT_SEPARATOR_NOT_ACCEPT("[ERROR] 올바르지 못한 구분자가 입력되었습니다."),
    INPUT_REGEX_NOT_ACCEPT("[ERROR] 올바르지 못한 형식의 입력입니다."),
    INPUT_PRODUCT_NAME_HAS_DUPLICATED("[ERROR] 중복된 상품이 입력되었습니다."),
    INPUT_HAS_NULL("[ERROR] 상품 입력에 null이 포함되었습니다.")
    ;

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
