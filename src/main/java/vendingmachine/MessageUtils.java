package vendingmachine;

public enum MessageUtils {
    ERROR("[ERROR]");

    private final String msg;

    MessageUtils(String msg) {
        this.msg = msg;
    }

    public String msg() {
        return msg;
    }
}
