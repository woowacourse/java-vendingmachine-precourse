package vendingmachine;

public class NumberManager {
    public static final int TYPE_AMOUNT = 0;
    public static final int TYPE_COUNT = 1;

    private static final int AMOUNT_UNIT = 10;

    public NumberManager() {
    }

    public static int toNumber(String numberString, int type) {
        int number = toInt(numberString);
        if (type == TYPE_AMOUNT && isAmountError(number)) {
            Error.AMOUNT_FORM.generate();
        }
        if (type == TYPE_COUNT && isCountError(number)) {
            Error.COUNT_FORM.generate();
        }
        return number;
    }

    private static int toInt(String numberString) {
        int number;
        try {
            number = Integer.parseInt(numberString);
            return number;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static boolean isAmountError(int amount) {
        if (amount <= 0 || amount % AMOUNT_UNIT > 0) {
            return true;
        }
        return false;
    }

    private static boolean isCountError(int count) {
        if (count <= 0) {
            return true;
        }
        return false;
    }
}
