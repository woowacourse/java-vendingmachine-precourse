package vendingmachine.user;

public class UserValidation {
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
}
