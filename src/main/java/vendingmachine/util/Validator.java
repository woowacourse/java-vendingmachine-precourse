package vendingmachine.util;

import java.util.regex.Pattern;

public class Validator {
    private static String ERROR_VENDINGMACHINE_SENETENCE = "[ERROR] 올바른 자판기 보유 금액이 아닙니다.";

    public boolean isValidVendingmachineChange(String input) {
        if (!isNumber(input)
                || !isNaturalNumber(input)
                || !isDivideByDivisor(input)) {
            throw new IllegalArgumentException(ERROR_VENDINGMACHINE_SENETENCE);
        }
        return true;
    }

    private boolean isNumber(String input) {
        Pattern pattern = Pattern.compile("^[0-9]$");
        return pattern.matcher(input).matches();
    }

    private boolean isNaturalNumber(String input) {
        return Integer.parseInt(input) >= 0;
    }

    private boolean isDivideByDivisor(String input) {
        return Integer.parseInt(input) % 10 == 0;
    }
}
