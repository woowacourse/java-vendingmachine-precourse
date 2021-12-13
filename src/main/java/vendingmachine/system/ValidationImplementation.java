package vendingmachine.system;

import java.util.regex.Pattern;

public class ValidationImplementation implements Validation {

    private static final int MINIMUM_HOLDING_MONEY = 100;
    private static final int HOLDING_MONEY_LIMITED_LENGTH = 9;
    private static final int PRODUCT_INFORMATION_DEFAULT_FORMAT_SIZE = 3;
    private static final Pattern HANGLE_PATERN = Pattern.compile("^[가-힣]*$");
    private static final Pattern DIGIT_PATERN = Pattern.compile("^[0-9]*$");

    public boolean isValidHoldingMoney(String holdingMoney) {
        boolean result = true;
        if (!isOnlyDigit(holdingMoney)) {
            throw new IllegalArgumentException();
        }

        if (isMoreThan100Million(holdingMoney) || isLessThan100(holdingMoney)) {
            throw new IllegalArgumentException();
        }

        if (!isDivisibleBy10(holdingMoney)) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    private boolean isLessThan100(String holdingMoney) {
        return Integer.parseInt(holdingMoney) < MINIMUM_HOLDING_MONEY;
    }

    private boolean isMoreThan100Million(String holdingMoney) {
        return holdingMoney.length() > HOLDING_MONEY_LIMITED_LENGTH;
    }

    private boolean isDivisibleBy10(String holdingMoney) {
        return Integer.parseInt(holdingMoney) % 10 == 0;
    }

    @Override
    public boolean isValidProductNameAndPriceAndStock(String productInformations) {
        if (isExistBlank(productInformations)) {
            throw new IllegalArgumentException();
        }

        String[] productInformation = productInformations.split(";");
        for (int index = 0; index < productInformation.length; index++) {
            if (!isCorrectBracket(productInformation[index])) {
                throw new IllegalArgumentException();
            }
            String removeBracketProductInformation = productInformation[index]
                .substring(1, productInformation[index].length() - 1);
            String[] productNameAndPriceAndQuantity = removeBracketProductInformation.split(",");
            if (!isCorrectDefaultFormatSize(productNameAndPriceAndQuantity)) {
                throw new IllegalArgumentException();
            }

            String productName = productNameAndPriceAndQuantity[0];
            if (!isOnlyHangle(productName)) {
                throw new IllegalArgumentException();
            }
            String price = productNameAndPriceAndQuantity[1];
            String quantity = productNameAndPriceAndQuantity[2];
            if (!isOnlyDigit(price) || !isDivisibleBy10(price) || !isOnlyDigit(quantity)) {
                throw new IllegalArgumentException();
            }
            if (isMoreThan100Million(price) || isMoreThan100Million(quantity)) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    private boolean isOnlyDigit(String priceOrQuantiy) {
        return DIGIT_PATERN.matcher(priceOrQuantiy).matches();
    }

    private boolean isOnlyHangle(String productName) {
        return HANGLE_PATERN.matcher(productName).matches();
    }

    private boolean isCorrectDefaultFormatSize(String[] productInfomation) {
        if (productInfomation.length != PRODUCT_INFORMATION_DEFAULT_FORMAT_SIZE) {
            return false;
        }
        return true;
    }

    private boolean isCorrectBracket(String productNameAndPriceAndStock) {
        if (productNameAndPriceAndStock.charAt(0) != '['
            || productNameAndPriceAndStock.charAt(productNameAndPriceAndStock.length() - 1) != ']') {
            return false;
        }
        return true;
    }

    private boolean isExistBlank(String inputProductInformation) {
        return inputProductInformation.indexOf(' ') != -1;
    }

    @Override
    public boolean isValidUserInsertMoney(String userInsertMoney) {
        if (!isOnlyDigit(userInsertMoney)) {
            throw new IllegalArgumentException();
        }

        if (isMoreThan100Million(userInsertMoney) || !isDivisibleBy10(userInsertMoney)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    @Override
    public boolean isValidProductNameToBuy(String productName) {
        if (!isOnlyHangle(productName)) {
            throw new IllegalArgumentException();
        }
        if (isExistBlank(productName)) {
            throw new IllegalArgumentException();
        }
        if (isZeroLengthString(productName)) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    private boolean isZeroLengthString(String productName) {
        return productName.length() == 0;
    }

}
