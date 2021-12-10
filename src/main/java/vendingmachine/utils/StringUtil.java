package vendingmachine.utils;

import static vendingmachine.Constant.*;
import static vendingmachine.ErrorMessage.*;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtil {

    public static boolean isEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }

    public static int parseStringToInt(String inputInitialAmount) {
        if (inputInitialAmount.matches(NUMBER_REGEX)) {
            return Integer.parseInt(inputInitialAmount);
        }
        throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
    }

    public static ArrayList<String> splitUsingSemiColon(String inputProductsInfo) {
        return new ArrayList<>(Arrays.asList(inputProductsInfo.split(PRODUCT_DELIMETER, -1)));
    }
}
