package vendingmachine.validator;

import vendingmachine.domain.ProductList;
import vendingmachine.domain.Product;

import java.util.HashMap;

public class Validator {
    private static final String ERROR_NOT_ALLOW_UNITS = "1원 단위는 허용되지 않습니다.";
    private static final String ERROR_NOT_STOCK_FOR_SALE = "상품의 재고가 없습니다.";
    private static final String ERROR_GREATER_THAN_ZERO = "0 이하의 숫자를 입력할 수 없습니다.";
    private static final String ERROR_ONLY_INTEGER = "금액은 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_PRICE_PREFIX = "상품 가격이 ";
    private static final String ERROR_MESSAGE_AMOUNT_PREFIX = "수량이 ";
    private static final String ERROR_NOT_DUPLICATE = "상품명은 중복될 수 없습니다.";
    private static final String ERROR_LOWER_THAN_HUNDRED = "100보다 작을 수 없습니다.";
    private static final String ERROR_PERMIT_ONLY_RULE = "[상품명,가격,수량]의 형식으로 정확히 입력해주세요.";
    private static final String ERROR_ONLY_ALLOW_SEMICOLON = "상품 구분은 세미콜론(;)을 통해 입력해야합니다.";
    private static final String ERROR_NOT_INSERTED_PRODUCT = "상품이 입력되지 않았습니다.";
    private static final String ERROR_NOT_PAIR_OF_BRACKET = "대괄호 쌍이 맞지않습니다.";
    private static final String ERROR_LESS_THAN_MINIMUM = "투입 금액보다 저렴한 상품이 없습니다.";
    private static final String ERROR_NOT_FOUND_PRODUCT = "입력한 상품이 존재하지 않습니다.";
    private static final String ERROR_NOT_STOCK_PRODUCT = "입력한 상품의 재고가 없습니다.";
    private static final String BRACKET_START = "[";
    private static final String BRACKET_END = "]";
    private static final String PRODUCT_SPLIT_REGEX = ";";
    private static final String PRODUCT_INFO_SPLIT_REGEX = ",";
    private static final String STRING_SPLIT_REGEX = "";
    private static final int PRODUCT_INFO_LENGTH = 3;
    private static final int HUNDRED = 100;
    private static final int TENS = 10;
    private static final int ZERO = 0;

    public int validateOnlyInteger(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_ONLY_INTEGER);
        }
    }

    public void isMultipleOfTen(int inputInteger) {
        if (inputInteger % TENS != ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_ALLOW_UNITS);
        }
    }

    public void isGreatThanZero(int inputInteger) {
        if (inputInteger <= ZERO) {
            throw new IllegalArgumentException(ERROR_GREATER_THAN_ZERO);
        }
    }

    public void validatePriceGreaterThanHundred(int price) {
        if (price < HUNDRED) {
            throw new IllegalArgumentException(ERROR_LOWER_THAN_HUNDRED);
        }
    }

    public void validateGreaterThanMinimumPrice(ProductList productList, int money) {
        if (!productList.compareMinimumPrice(money)) {
            throw new IllegalArgumentException(ERROR_LESS_THAN_MINIMUM);
        }
    }

    public void validateExistedProduct(ProductList productList, String productName) {
        if (!productList.existProductName(productName)) {
            throw new IllegalArgumentException(ERROR_NOT_FOUND_PRODUCT);
        }
    }

    public void validateProductIsAvailable(ProductList productList, String productName) {
        if (!productList.isAvailableProduct(productName)) {
            throw new IllegalArgumentException(ERROR_NOT_STOCK_PRODUCT);
        }
    }

    public String validateDuplicateProductName(HashMap<String, Product> productMap, String name) {
        if (productMap.get(name) != null) {
            throw new IllegalArgumentException(ERROR_NOT_DUPLICATE);
        }
        return name;
    }

    public String[] validateProductInfoSplitRegex(String productInformation) {
        String[] splitProductInfo = productInformation.split(PRODUCT_INFO_SPLIT_REGEX);
        if (splitProductInfo.length != PRODUCT_INFO_LENGTH) {
            throw new IllegalArgumentException(ERROR_PERMIT_ONLY_RULE);
        }
        return splitProductInfo;
    }

    public String[] validateSplitRegex(String productsInformation) {
        int countOfBracket = getCountOfSquareBracket(productsInformation);
        int countOfSplitRegex = getCountOfSplitRegex(productsInformation);
        if (countOfBracket < 1) {
            throw new IllegalArgumentException(ERROR_NOT_INSERTED_PRODUCT);
        }
        if (countOfBracket > 1 && countOfBracket - 1 != countOfSplitRegex) {
            throw new IllegalArgumentException(ERROR_ONLY_ALLOW_SEMICOLON);
        }
        return productsInformation.split(PRODUCT_SPLIT_REGEX);
    }

    private int getCountOfSquareBracket(String productsInformation) {
        int countOfBracketStart = 0;
        int countOfBracketEnd = 0;
        for (String productString : productsInformation.split(STRING_SPLIT_REGEX)) {
            if (productString.equals(BRACKET_START)) {
                countOfBracketStart++;
            }
            if (productString.equals(BRACKET_END)) {
                countOfBracketEnd++;
            }
        }
        if (countOfBracketStart != countOfBracketEnd) {
            throw new IllegalArgumentException(ERROR_NOT_PAIR_OF_BRACKET);
        }
        return countOfBracketStart;
    }

    private int getCountOfSplitRegex(String productsInformation) {
        int countOfSplitRegex = 0;
        for (String productString : productsInformation.split(STRING_SPLIT_REGEX)) {
            if (productString.equals(PRODUCT_SPLIT_REGEX)) {
                countOfSplitRegex++;
            }
        }
        return countOfSplitRegex;
    }

    public Product validateSplitProductInformation(HashMap<String, Product> productMap, String productInformation) {
        productInformation = removeBracketInProduct(productInformation);
        String[] productInformationList = this.validateProductInfoSplitRegex(productInformation);
        String name = this.validateDuplicateProductName(productMap, productInformationList[0]);
        int price = validatePrice(productInformationList[1]);
        int amount = validateAmount(productInformationList[2]);
        return new Product(name, price, amount);
    }

    public void validateProductStock(Product product) {
        if (!product.existStock()) {
            throw new IllegalArgumentException(ERROR_NOT_STOCK_FOR_SALE);
        }
    }

    private String removeBracketInProduct(String productsInformation) {
        return productsInformation.substring(1, productsInformation.length() - 1);
    }

    private int validatePrice(String price) {
        try {
            int integerPrice = this.validateOnlyInteger(price);
            this.validatePriceGreaterThanHundred(integerPrice);
            this.isMultipleOfTen(integerPrice);
            return integerPrice;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PRICE_PREFIX + exception.getMessage());
        }
    }

    private int validateAmount(String amount) {
        try {
            int integerAmount = this.validateOnlyInteger(amount);
            this.isGreatThanZero(integerAmount);
            return integerAmount;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_AMOUNT_PREFIX + exception.getMessage());
        }
    }
}
