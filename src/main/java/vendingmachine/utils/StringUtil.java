package vendingmachine.utils;

import static vendingmachine.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {

    public static boolean isEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }

    public static int parseStringToInt(String inputInitialAmount) {
        if (inputInitialAmount.matches(NUMBER_REGEX)) {
            return Integer.parseInt(inputInitialAmount);
        }
        throw new IllegalArgumentException("숫자를 입력해주세요.");
    }

    public static ArrayList<String> splitUsingSemiColon(String inputProductsInfo) {
        return new ArrayList<>(Arrays.asList(inputProductsInfo.split(";", -1)));
    }
}
