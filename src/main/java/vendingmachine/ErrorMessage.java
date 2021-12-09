package vendingmachine;

public enum ErrorMessage {
    NO_COIN_MATCH("해당 금액에 해당하는 동전이 없습니다."),
    ;

    public static final String ERROR_PREFIX = "[ERROR]";

    private String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getCompleteMessage() {
        return ERROR_PREFIX + getText();
    }

}
