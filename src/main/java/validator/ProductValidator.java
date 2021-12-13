package validator;

public class ProductValidator {
    private static final String REGEX = "\\[[A-Za-z0-9가-힣]+,\\d+,\\d+]";
    private static final String DELIMITER = ",";

    private static final int SUBSTRING_INDEX = 1;
    private static final int FALSE_NUMBER = 0;
    private static final int DIVIDE_STANDARD = 10;
    private static final int PRICE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    public static String[] validateInput(String input) {
        String removedInput = input.substring(SUBSTRING_INDEX, input.length() - 1);
        String[] tempProductList = removedInput.split(";");
        String[] tempProduct = new String[3];
        for (int i = 0; i < tempProductList.length; i++) {
            tempProduct = tempProductList[i].split(DELIMITER);
        }
        isPriceNotDivideByTen(tempProduct[PRICE_INDEX]);
        isAmountUnderZero(tempProduct[AMOUNT_INDEX]);
        return tempProduct;
    }

    private static void MatchRegex(String removedInput) {
        if (!removedInput.matches(REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PHRASE + ExceptionMessage.ERROR_INPUT_REGEX);
        }
    }

    private static void isPriceNotDivideByTen(String input) {
        if (Integer.parseInt(input) % DIVIDE_STANDARD != FALSE_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PHRASE + ExceptionMessage.ERROR_INPUT_MULTIPLICATION_OF_TEN);
        }
    }

    private static void isAmountUnderZero(String input) {
        if (Integer.parseInt(input) <= FALSE_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PHRASE + ExceptionMessage.ERROR_INPUT_POSITIVE_NUMBER);
        }
    }
}
