package vendingmachine.utils;

public class ValidationUtil {
    public static void checkAmount(String value) {
        if (!value.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력주세요.");
        }
    }

    public static boolean isValidAmount(String value) {
        try {
            ValidationUtil.checkAmount(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
