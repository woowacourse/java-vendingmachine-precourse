package vendingmachine.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vendingmachine.domain.constant.Product;
import vendingmachine.exception.ExceptionHandler;

import static vendingmachine.exception.ErrorCode.*;

public class Parser {
    private static final int POSITIVE_NUMBER_MINIMUM_RANGE = 1;
    private static final Pattern REGEX_COIN_PATTERN = Pattern.compile("^[1-9]+0$");
    private static final Pattern REGEX_PRODUCT_PATTERN = Pattern.compile("^\\[\\w+,\\d+,\\d+\\](;\\[\\w+,\\d+,\\d+\\])*$");
    private static final Pattern REGEX_PRICE_PATTERN =Pattern.compile("^100$|^1[1-9][0-9]0$");
    private static final Pattern REGEX_MENU_PATTERN=Pattern.compile("^.+$");
    private static Map<String, Product> productMap;
    // Default Constructor
    private Parser() {
    }

    //== Business Logic ==//
    public static int parseMoneyInput(String coninInput) {
        INVALID_COIN_INPUT.validate(() -> hasWhitespace(coninInput));
        INVALID_INPUT.validate(() -> isInvalidCoinPattern(coninInput));
        return ExceptionHandler.tryOnParseIntException(() -> Integer.parseInt(coninInput));
    }

    public static Map<String, Product> parseVMProductsInput(String productsInput) {
        Matcher matcher = productFormatValidation(productsInput);
        return ExceptionHandler.tryOnParseIntException(() -> parseProducts(matcher));
    }

    public static String parseMenuInput(String menuInput) {
        INVALID_ORDER.validate(() -> hasWhitespace(menuInput));
        INVALID_ORDER.validate(() -> isInvalidMenuPattern(menuInput));
        return menuInput;
    }


    private static Map<String, Product> parseProducts(Matcher matcher){
        productMap = new HashMap<>();

        while (matcher.find()) {
            String productName = productProductNameValidation(matcher.group(1));
            int price = productProductPriceValidation(matcher.group(2));
            int quantity = productProductQuantityValidation(matcher.group(3));

            Product product = new Product(productName, price, quantity);
            productMap.put(productName, product);
        }

        return productMap;
    }

    private static Matcher productFormatValidation(String productsInput){
        INVALID_PRODUCT_FORMAT.validate(() -> hasWhitespace(productsInput));
        INVALID_PRODUCT_FORMAT.validate(() -> isInvalidProductPattern(productsInput));
        return REGEX_PRODUCT_PATTERN.matcher(productsInput);
    }

    private static String productProductNameValidation(String nameInput){
        INVALID_PRODUCT_NAME.validate(() -> hasWhitespace(nameInput));
        return nameInput;
    }

    private static int productProductPriceValidation(String priceInput){
        INVALID_PRODUCT_PRICE.validate(() -> hasWhitespace(priceInput));
        INVALID_PRODUCT_PRICE.validate(() -> isInvalidPricePattern(priceInput));
        return ExceptionHandler.tryOnParseIntException(() -> Integer.parseInt(priceInput));
    }

    private static int productProductQuantityValidation(String quantityInput){
        INVALID_PRODUCT_QUANTITY.validate(() -> hasWhitespace(quantityInput));
        int price = ExceptionHandler.tryOnParseIntException(() -> Integer.parseInt(quantityInput));
        INVALID_PRODUCT_NAME.validate(() -> isNotPositiveInteger(price));
        return price;
    }

    private static boolean isNotPositiveInteger(Integer value) {
        return value < POSITIVE_NUMBER_MINIMUM_RANGE;
    }

    //== Validation Method ==//
    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    private static boolean isInvalidCoinPattern(String input) {
        return matchWithRegex(input, REGEX_COIN_PATTERN);
    }

    private static boolean isInvalidProductPattern(String input) {
        return matchWithRegex(input, REGEX_PRODUCT_PATTERN);
    }

    private static boolean isInvalidPricePattern(String input) {
        return matchWithRegex(input, REGEX_PRICE_PATTERN);
    }

    private static boolean isInvalidMenuPattern(String input) {
        return matchWithRegex(input, REGEX_MENU_PATTERN);
    }

    // == 정규표현식 제약 조건== //
    private static boolean matchWithRegex(String input, Pattern regex) {
        Matcher matcher = regex.matcher(input);
        return !matcher.matches();
    }
}
