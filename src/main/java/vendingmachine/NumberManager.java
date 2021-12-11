package vendingmachine;

public class NumberManager {
    private static final boolean ERROR = true;
    private static final boolean NON_ERROR = false;

    public static final int TYPE_AMOUNT = 0;
    public static final int TYPE_COUNT = 1;

    private static final int AMOUNT_UNIT = 10;

    public NumberManager() {}

    public int toNumber(String numberString, int type) {
        int number = toInt(numberString);
        if (type == TYPE_AMOUNT && isAmountError(number)) {
            System.out.println("[ERROR] 가격(금액)은 10으로 나누어 떨어지는 자연수로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (type == TYPE_COUNT && isCountError(number)) {
            System.out.println("[ERROR] 상품 수량은 자연수로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return number;
    }

    private int toInt(String numberString) {
        int number;
        try {
            number = Integer.parseInt(numberString);
            return number;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean isAmountError(int amount) {
        if (amount < 0 || amount % AMOUNT_UNIT > 0) {
            return ERROR;
        }
        return NON_ERROR;
    }

    private boolean isCountError(int count) {
        if (count < 0) {
            return ERROR;
        }
        return NON_ERROR;
    }
}
