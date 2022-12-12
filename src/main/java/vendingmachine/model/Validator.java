package vendingmachine.model;

import java.util.Map;

import static vendingmachine.util.NumberConsts.MIN_PRICE;
import static vendingmachine.util.NumberConsts.MIN_UNIT;
import static vendingmachine.util.NumberConsts.NUMBER_OF_ELEMENTS;
import static vendingmachine.util.message.ErrorMessage.INVALID_FORMAT;
import static vendingmachine.util.message.ErrorMessage.INVALID_PRICE;
import static vendingmachine.util.message.ErrorMessage.INVALID_UNIT;
import static vendingmachine.util.message.ErrorMessage.IS_NEGATIVE;
import static vendingmachine.util.message.ErrorMessage.NOT_NUMBER;
import static vendingmachine.util.message.ProductErrorMessage.INSUFFICIENT_BALANCE;
import static vendingmachine.util.message.ProductErrorMessage.INVALID_NAME;
import static vendingmachine.util.message.ProductErrorMessage.NOT_FOR_SALE;
import static vendingmachine.util.message.ProductErrorMessage.OUT_OF_STOCK;

public class Validator {

    public static int validateBalance(String input) throws IllegalArgumentException {
        int balance = validateNum(input);
        validateNegative(balance);
        validateInvalidUnit(balance);
        return balance;
    }

    public static int validateAmountOfInput(String input) throws IllegalArgumentException {
        int amountOfInput = validateNum(input);
        validateNegative(amountOfInput);
        return amountOfInput;
    }

    public static void validatePrice(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException(INVALID_PRICE.fullMessage());
        }
        validateInvalidUnit(price);
    }

    public static void validateProduct(String[] productInfo, Map<String, Product> products) throws IllegalArgumentException {
        if (productInfo.length != NUMBER_OF_ELEMENTS) {
            throw new IllegalArgumentException(INVALID_FORMAT.fullMessage());
        }
        if (products.containsKey(productInfo[0])) {
            throw new IllegalArgumentException(INVALID_NAME.fullMessage());
        }
    }

    public static void validateBuyingProduct(String buyingProduct, Map<String, Product> products,
                                             int amountOfInput) throws IllegalArgumentException {
        if (!products.containsKey(buyingProduct)) {
            throw new IllegalArgumentException(NOT_FOR_SALE.fullMessage());
        }
        if (products.get(buyingProduct).getPrice() > amountOfInput) {
            throw new IllegalArgumentException(INSUFFICIENT_BALANCE.fullMessage());
        }
        if (!products.get(buyingProduct).stockIsLeft()) {
            throw new IllegalArgumentException(OUT_OF_STOCK.fullMessage());
        }
    }

    public static int validateNum(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.fullMessage());
        }
    }

    public static void validateNegative(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException(IS_NEGATIVE.fullMessage());
        }
    }

    public static void validateInvalidUnit(int num) throws IllegalArgumentException {
        if (num % MIN_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_UNIT.fullMessage());
        }
    }
}
