package util.message;

import util.EnumUtil;

public enum ExceptionMessage implements EnumUtil<String, String> {
    BLANK_MESSAGE("%s은(는) 빈 값이 들어올 수 없습니다.")
    , TYPE_MESSAGE("%s은(는) 숫자만 입력할 수 있습니다.")
    , RANGE_MESSAGE("%d 보다 큰 값을 입력해 주세요.")
    , UNIT_MESSAGE("%d원 단위로 입력해 주세요.")
    , DUPLICATE_MESSAGE("%s을(를) 중복으로 입력할 수 없습니다.")
    , NO_RESOURCE_MESSAGE("%s(이)가 존재하지 않습니다.")
    , NOT_COIN_MESSAGE("해당하는 %d원 동전이 존재하지 않습니다.");
    private static final String ERROR_TAG = "[ERROR] ";
    private final String message;

    public String getMessage(){
        return message;
    }

    ExceptionMessage(final String message) {
        this.message = ERROR_TAG + message;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}
