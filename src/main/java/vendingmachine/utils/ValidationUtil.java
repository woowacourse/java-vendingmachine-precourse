package vendingmachine.utils;

public class ValidationUtil {
    public static void checkAmount(String value) {
        checkIsDigit(value);
        checkIsMultipleOfStandard(value);
    }

    public static void checkIsMultipleOfStandard(String value) {
        int number = Integer.parseInt(value);
        if (number == 0 || number % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10의 단위로 입력주세요.");
        }
    }

    public static void checkIsDigit(String value) {
        if (!value.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력주세요.");
        }
    }

    // public static void checkProductContent(String value) {
    //     checkIsEmptyProductContent(value);
    //     FormatUtil.convertToProductsElement(value).forEach(elements -> {
    //         if(elements[0])
    //     });
    // }
    //
    // private static void checkIsEmptyProductContent(String value) {
    //     if(value.isEmpty()) {
    //         throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
    //     }
    // }
}
