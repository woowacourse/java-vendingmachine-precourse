package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import vendingmachine.validator.GeneralValidator;

public class Product {

    private static final String ERR_HEADER = "[ERROR]";
    private static final String ERR_INVALID_FORMAT = ERR_HEADER + "잘못된 상품정보 형식입니다.";
    private static final String ERR_INVALID_STOCK = ERR_HEADER + "재고가 비어있으면 안됩니다.";
    private static final String ERR_INVALID_PRICE = ERR_HEADER + "상품 가격은 100원 이상이여야 하고 10원으로 나누어 떨어져야합니다.";
    private static final String ERR_INVALID_NAME = ERR_HEADER + "상품 이름이름은 글자와 숫자만 허용됩니다..";
    private static final char INFO_PREFIX = '[';
    private static final char INFO_SUFFIX = ']';
    private static final char INFO_DELIMITER = ',';
    private static final int INFO_PREFIX_POSITION = 0;
    private static final int INFO_NAME_POSITION = 0;
    private static final int INFO_PRICE_POSITION = 1;
    private static final int INFO_STOCK_POSITION = 2;
    private static final int INFO_FIELDS = 3;
    private static final int EMPTY = 0;
    private static final int MIN_AMOUNT = 10;
    private static final int MIN_PRICE = 100;

    private final String name;
    private int stock;
    private int price;

    private Product(String name, int stock, int price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public static Product getValidProduct(String info) {
        List<String> fields = Arrays.asList(
            info.substring(INFO_PREFIX_POSITION + 1, info.length() - 1)
                .split(String.valueOf(INFO_DELIMITER)));
        validateProductInfoFormat(info);
        validateFields(fields);
        return new Product(fields.get(INFO_NAME_POSITION),
            Integer.parseInt(fields.get(INFO_STOCK_POSITION)),
            Integer.parseInt(fields.get(INFO_PRICE_POSITION)));
    }

    private static void validateProductInfoFormat(String info) {
        if (info.charAt(INFO_PREFIX_POSITION) != INFO_PREFIX
            || info.charAt(info.length() - 1) != INFO_SUFFIX) {
            throw new IllegalArgumentException(ERR_INVALID_FORMAT);
        }
    }

    private static void validateFields(List<String> fields) {
        if (fields.size() != INFO_FIELDS) {
            throw new IllegalArgumentException(ERR_INVALID_FORMAT);
        }
        validateName(fields.get(INFO_NAME_POSITION));
        validateStock(fields.get(INFO_STOCK_POSITION));
        validatePrice(fields.get(INFO_PRICE_POSITION));
    }

    private static void validateName(String name) {
        if (!name.chars().allMatch(Character::isLetterOrDigit)
            || name.chars().anyMatch(Character::isSpaceChar)) {
            throw new IllegalArgumentException(ERR_INVALID_NAME);
        }
    }
    
    private static void validateStock(String stock) {
        GeneralValidator.validateNumeric(stock);
        if (Integer.parseInt(stock) == EMPTY) {
            throw new IllegalArgumentException(ERR_INVALID_STOCK);
        }
    }
    
    private static void validatePrice(String price) {
        GeneralValidator.validateNumeric(price);
        int converted = Integer.parseInt(price);
        if (converted < MIN_PRICE || converted % MIN_AMOUNT != 0) {
            throw new IllegalArgumentException(ERR_INVALID_PRICE);
        }
    }
}
