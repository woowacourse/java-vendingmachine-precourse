package vendingmachine.system.validation;

import java.util.regex.Pattern;

public class ValidationImplementation implements Validation {

    private static final int MINIMUM_HOLDING_MONEY = 100;
    private static final int HOLDING_MONEY_LIMITED_LENGTH = 9;
    private static final int PRODUCT_INFORMATION_DEFAULT_FORMAT_SIZE = 3;
    private static final int ZERO_VALUE=0;
    private static final Pattern HANGLE_PATTERN = Pattern.compile("^[가-힣]*$");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("^[0-9]*$");

    private ValidationImplementation() {}

    private static class LazyHolder {
        public static final ValidationImplementation INSTANCE = new ValidationImplementation();
    }

    public static ValidationImplementation getInstance(){
        return ValidationImplementation.LazyHolder.INSTANCE;
    }

    @Override
    public boolean isValidHoldingMoney(String holdingMoney) {
        boolean result = true;
        if (isZeroLengthString(holdingMoney)) {
            throw new IllegalArgumentException();
        }
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

    @Override
    public boolean isValidProductNameAndPriceAndStock(String productInformations) {
        if (isZeroLengthString(productInformations)) {
            throw new IllegalArgumentException();
        }
        if (isExistBlank(productInformations)) {
            throw new IllegalArgumentException();
        }
        String[] productInformation = productInformations.split(";");
        for (int index = 0; index < productInformation.length; index++) {
            if (!isCorrectBracket(productInformation[index])) {
                throw new IllegalArgumentException();
            }
            String[] productNameAndPriceAndQuantity = checkDefaultFormatSize(productInformation[index]);
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

    @Override
    public boolean isValidUserInsertMoney(String userInsertMoney) {
        if (isZeroLengthString(userInsertMoney)) {
            throw new IllegalArgumentException();
        }

        if (!isOnlyDigit(userInsertMoney) || Integer.parseInt(userInsertMoney)==ZERO_VALUE) {
            throw new IllegalArgumentException();
        }

        if (isMoreThan100Million(userInsertMoney) || !isDivisibleBy10(userInsertMoney)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    @Override
    public boolean isValidProductNameToBuy(String productName) {
        if (isZeroLengthString(productName)) {
            throw new IllegalArgumentException();
        }
        if (!isOnlyHangle(productName)) {
            throw new IllegalArgumentException();
        }
        if (isExistBlank(productName)) {
            throw new IllegalArgumentException();
        }

        return true;
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

    private String[] checkDefaultFormatSize(String s) {
        String removeBracketProductInformation = s.substring(1, s.length() - 1);
        String[] productNameAndPriceAndQuantity = removeBracketProductInformation.split(",");
        if (!isCorrectDefaultFormatSize(productNameAndPriceAndQuantity)) {
            throw new IllegalArgumentException();
        }
        return productNameAndPriceAndQuantity;
    }

    private boolean isOnlyDigit(String priceOrQuantiy) {
        return DIGIT_PATTERN.matcher(priceOrQuantiy).matches();
    }

    private boolean isOnlyHangle(String productName) {
        return HANGLE_PATTERN.matcher(productName).matches();
    }

    private boolean isCorrectDefaultFormatSize(String[] productInfomation) {
        if (productInfomation.length != PRODUCT_INFORMATION_DEFAULT_FORMAT_SIZE) {
            return false;
        }
        return true;
    }

    private boolean isCorrectBracket(String productNameAndPriceAndStock) {
        if (productNameAndPriceAndStock.charAt(0) != '[' || productNameAndPriceAndStock.charAt(productNameAndPriceAndStock.length() - 1) != ']') {
            return false;
        }
        return true;
    }

    private boolean isExistBlank(String inputProductInformation) {
        return inputProductInformation.indexOf(' ') != -1;
    }

    private boolean isZeroLengthString(String productName) {
        return productName.length() == 0;
    }

}
