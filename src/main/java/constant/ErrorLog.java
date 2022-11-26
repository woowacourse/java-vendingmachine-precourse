package constant;

public enum ErrorLog {
    ERROR_MARK("[ERROR]"),
    SPACE(" "),
    ZERO_NUMBER("0이 될 수 없습니다."),
    NOT_DIVISIBLE("10원 단위가 아닙니다."),
    NOT_ENOUGH_MONEY("가격이 100원 미만입니다."),
    NOT_NUMBER_INPUT("입력이 숫자가 아닙니다.");

    private final String log;
    ErrorLog(String log) {
        this.log = log;
    }

    public String getLog() {
        return ERROR_MARK.log
                + SPACE.log
                + log;
    }
}
