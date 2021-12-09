package vendingmachine.utils;

import static vendingmachine.Constant.*;

public class StringUtil {

    public static int parseStringToInt(String inputInitialAmount) {
        if (inputInitialAmount.matches(NUMBER_REGEX)) {
            return Integer.parseInt(inputInitialAmount);
        }
        throw new IllegalArgumentException("숫자를 입력해주세요.");
    }
}
