package vendingmachine.controller;

import vendingmachine.domain.Product;

import java.util.Arrays;
import java.util.HashSet;

public class ValidationController {
    private static final String ERROR_NOT_DIVIDE_10 = "[ERROR] 10으로 나눠지지 않습니다.";
    private static final String ERROR_NOT_POSITIVE = "[ERROR] 양의 정수가 아닙니다.";
    private static final String ERROR_NOT_NUM = "[ERROR] 숫자가 아닙니다.";
    private static final String ERROR_NOT_COMMA = "[ERROR] 두 개의 콤마가 아닙니다.";
    private static final String ERROR_BRACKET = "[ERROR] 양 끝이 대괄호가 아닙니다.";
    private static final String ERROR_WRONG_STRUCTURE = "[ERROR] 잘못된 구조의 입력입니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 중복된 상품명 입력이 있습니다.";
    private static final String ERROR_UNDER_100 = "[ERROR] 100 미만의 수 입니다.";
    private static final String ERROR_HAVE_NOT = "[ERROR] 없는 상품명입니다.";

    private static final String BASE_SPLIT_FIRST = ";";
    private static final String BASE_SPLIT_SECOND = ",";

    private static final int BASE_DIVIDE = 10;
    private static final int BASE_UNDER = 100;

    public static void vendingMachineValidation(String input) {
        isNumValidation(input);
        positiveIntegerValidation(input);
        divided10Validation(input);
    }

    private static void divided10Validation(String input) {
        int checkNum = Integer.parseInt(input);
        if (checkNum % BASE_DIVIDE != 0) {
            throw new IllegalArgumentException(ERROR_NOT_DIVIDE_10);
        }
    }

    private static void positiveIntegerValidation(String input) {
        int checkNum = Integer.parseInt(input);
        if (checkNum <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE);
        }
    }

    private static void isNumValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_NOT_NUM);
        }
    }

    public static void productValidation(String productInfo) {
        String[] productData = productInfo.split(BASE_SPLIT_FIRST);
        bracketsValidation(productData);
        removeBrackets(productData);
        commaValidation(productData);
        blankValidation(productData);
    }

    private static void removeBrackets(String[] productData) {
        for (int i = 0; i < productData.length; i++) {
            productData[i] = productData[i].substring(1, productData[i].length() - 1);
        }
    }

    private static void commaValidation(String[] productData) {
        for (String productDatum : productData) {
            if (countChar(productDatum, ',') != 2) {
                throw new IllegalArgumentException(ERROR_NOT_COMMA);
            }
        }
    }

    private static int countChar(String str, char checkChar) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == checkChar) {
                count++;
            }
        }
        return count;
    }


    private static void bracketsValidation(String[] productData) {
        for (String productDatum : productData) {
            if (!(productDatum.charAt(0) == '[' && productDatum.charAt(productDatum.length() - 1) == ']')) {
                throw new IllegalArgumentException(ERROR_BRACKET);
            }
        }
    }

    private static void blankValidation(String[] productData) {
        for (String productDatum : productData) {
            String[] splitData = productDatum.split(BASE_SPLIT_SECOND);
            if (splitData.length != 3) {
                throw new IllegalArgumentException(ERROR_WRONG_STRUCTURE);
            }
        }
    }

    public static void duplicateValidation(String productInfo) {
        String[] productData = productInfo.split(BASE_SPLIT_FIRST);
        HashSet<String> checkProductName = new HashSet<>();

        for (String productDatum : productData) {
            String[] productSplitData = productDatum.split(BASE_SPLIT_SECOND);
            checkProductName.add(productSplitData[0].substring(1, productSplitData[0].length()));
        }

        if (productData.length != checkProductName.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    public static void productAmountValidation(String productInfo) {
        String[] productData = productInfo.split(BASE_SPLIT_FIRST);

        for (String productDatum : productData) {
            String[] productSplitData = productDatum.split(BASE_SPLIT_SECOND);
            isNumValidation(productSplitData[1]);
            positiveIntegerValidation(productSplitData[1]);
            divided10Validation(productSplitData[1]);
            under100Validation(productSplitData[1]);
        }
    }

    private static void under100Validation(String input) {
        int checkNum = Integer.parseInt(input);
        if (checkNum < BASE_UNDER) {
            throw new IllegalArgumentException(ERROR_UNDER_100);
        }
    }

    public static void quantityValidation(String productInfo) {
        String[] productData = productInfo.split(BASE_SPLIT_FIRST);

        for (String productDatum : productData) {
            String[] productSplitData = productDatum.split(BASE_SPLIT_SECOND);
            String checkStr = productSplitData[2].substring(0, productSplitData[2].length() - 1);
            isNumValidation(checkStr);
            positiveIntegerValidation(checkStr);
        }
    }

    public static void purchaseValidation(Product product, String productName) {
        if (!product.hasInProduct(productName)) {
            throw new IllegalArgumentException(ERROR_HAVE_NOT);
        }
    }
}
