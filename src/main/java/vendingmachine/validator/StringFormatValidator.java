package vendingmachine.validator;

import static vendingmachine.utils.ExceptionMessages.*;

public class StringFormatValidator {

    public static void validateMerchandiseInfoFormat(String merchandiseInfo) {
        String[] infoList = merchandiseInfo.substring(1, merchandiseInfo.length() - 1).split(",");
        validateIntType(infoList[1]);
        validateIntType(infoList[2]);
    }

    private static int validateIntType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(PRICE_NUMBER_NOT_NUMBER_EXCEPTION);
        }
    }
}
