package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import vendingmachine.validator.GeneralValidator;

public class Product {

    private static final String ERR_HEADER = "[ERROR]";
    private static final String ERR_INVALID_FORMAT = ERR_HEADER + "잘못된 상품정보 형식입니다.";
    private static final String ERR_INVALID_STOCK = ERR_HEADER + "재고가 비어있으면 안됩니다.";
    private static final String ERR_INVALID_PRICE =
        ERR_HEADER + "상품 가격은 100원 이상이고 10원으로 나누어 떨어져야합니다.";
    private static final String ERR_INVALID_NAME = ERR_HEADER + "상품 이름이름은 글자와 숫자만 허용됩니다..";
    private static final String ERR_INVALID_INPUT_AMOUNT = "투입금액이 상품가격보다 적습니다.";
    private static final String ERR_EMPTY_STOCK = "상품의 재고가 없습니다.";
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
    private int amount;

    private Product(String name, int stock, int price) {
        this.name = name;
        this.stock = stock;
        this.amount = price;
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

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return stock;
    }

    public int getAmount() {
        return amount;
    }

    public void sell(InputAmount inputAmount) throws IllegalArgumentException {
        validateDeal(inputAmount);
        this.stock--;
        inputAmount.consume(this.amount);
    }

    private void validateDeal(InputAmount inputAmount) throws IllegalArgumentException {
        if (this.amount > inputAmount.getAmount()) {
            throw new IllegalArgumentException(ERR_INVALID_INPUT_AMOUNT);
        }
        if (this.stock == EMPTY) {
            throw new IllegalArgumentException(ERR_EMPTY_STOCK);
        }
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
        String stock = fields.get(INFO_STOCK_POSITION);
        String amount = fields.get(INFO_PRICE_POSITION);
        GeneralValidator.validateNumeric(stock);
        GeneralValidator.validateNumeric(amount);
        validateName(fields.get(INFO_NAME_POSITION));
        validateStock(Integer.parseInt(stock));
        validateAmount(Integer.parseInt(amount));
    }

    private static void validateName(String name) {
        if (!name.chars().allMatch(Character::isLetterOrDigit)
            || name.chars().anyMatch(Character::isSpaceChar)) {
            throw new IllegalArgumentException(ERR_INVALID_NAME);
        }
    }

    private static void validateStock(int stock) {
        if (stock == EMPTY) {
            throw new IllegalArgumentException(ERR_INVALID_STOCK);
        }
    }

    private static void validateAmount(int amount) {
        if (amount < MIN_PRICE || amount % MIN_AMOUNT != 0) {
            throw new IllegalArgumentException(ERR_INVALID_PRICE);
        }
    }
}
