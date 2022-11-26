package constant;

public enum ErrorLog {
    ERROR_MARK("[ERROR]"),
    SPACE(" "),
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
