package vendingmachine.utils;

import java.util.Arrays;

public class VerificationUtil {

    private static final String REGEX = "^\\[[a-zA-Z가-힣]+,[1-9][0-9]+0,[1-9][0-9]*]$";

    private VerificationUtil() {
    }

    public static void validateHoldingAmount(String input) {
        int holdingAmount = getValidatedNumber(input);

        validatePositiveNumber(holdingAmount);
        validateMultipleOfTen(holdingAmount);
    }

    public static void validateProductInput(String input) {
        Arrays.stream(input.split(";"))
                .filter(s -> !s.matches(REGEX))
                .findAny()
                .ifPresent(s -> {
                    throw new IllegalArgumentException("[ERROR] 잘못된 상품 입력입니다.");
                });
    }

    private static int getValidatedNumber(String input) {
        try {
            int number = Integer.parseInt(input);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void validatePositiveNumber(int holdingAmount) {
        if (holdingAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }

    private static void validateMultipleOfTen(int holdingAmount) {
        if (holdingAmount % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10원 단위로 입력해주세요.");
        }
    }
}
