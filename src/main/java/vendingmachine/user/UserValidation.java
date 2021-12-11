package vendingmachine.user;

public class UserValidation {
    public static void isNumber(String money) {
        if (!money.matches("-?\\d+")) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_NUMBER);
        }
    }
}
