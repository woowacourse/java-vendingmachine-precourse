package vendingmachine.user;

public class UserMoneyValidation {
    public static void checkUserMoneyValidation(String money) {
        isEmpty(money);
        isNumber(money);
        isPositive(money);
        hasEmpty(money);
    }

    public static void isEmpty(String money) {
        if (money.length() == 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NULL);
        }
    }

    public static void isNumber(String money) {
        if (!money.matches("-?\\d+")) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_NUMBER);
        }
    }

    public static void isPositive(String money) {
        if (Integer.parseInt(money) <= 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_POSITIVE);
        }
    }

    public static void hasEmpty(String money) {
        if (money.contains(InputErrorConstant.EMPTY_SPACE)) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_HAS_SPACE);
        }
    }
}
