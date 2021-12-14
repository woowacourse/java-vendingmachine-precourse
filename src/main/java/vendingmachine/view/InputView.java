package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.Products;

import java.util.Arrays;

public class InputView {
    public static final int INDEX_OF_PRICE = 1;
    public static final int MINIMUM_PRICE = 100;
    public static final int MINIMUM_MONEY_UNIT = 10;
    public static final String REGEX_FOR_NUMBERS = "^[0-9]+$";
    public static final String DELIMITER_OF_PRODUCT_LIST_INFO = ";";
    public static final String DELIMITER_OF_SINGLE_PRODUCT_INFO = ",";
    public static final String INFO_MESSAGE_OF_MACHINE_COINS = "\n자판기가 보유한 동전";
    public static final String REQUEST_MESSAGE_FOR_PRODUCT_INFO = "\n상품명과 가격, 수량을 입력해 주세요.";
    private static final String ERROR_MESSAGE_FOR_INVALID_MONEY_INPUT = "[ERROR] 금액은 숫자여야 합니다.";
    public static final String REQUEST_MESSAGE_FOR_MONEY_INPUT_TO_PURCHASE = "\n투입 금액을 입력해주세요.";
    public static final String REQUEST_MESSAGE_FOR_PRODUCT_NAME_TO_PURCHASE = "\n구매할 상품명을 입력해 주세요.";
    public static final String ERROR_MESSAGE_FOR_INVALID_PRODUCT_NAME = "\n[ERROR] 상품명을 확인해주세요 : %s\n";
    public static final String ERROR_MESSAGE_FOR_TOO_LOW_PRICE = "[ERROR] 상품의 최저 가격은 " + MINIMUM_PRICE + "원 입니다 : ";
    public static final String REQUEST_MESSAGE_FOR_INITIAL_MONEY_OF_VENDINGMACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String ERROR_MESSAGE_FOR_INVALID_MONEY_UNIT = "[ERROR] 상품 가격 최소 단위는 " + MINIMUM_MONEY_UNIT + "원 입니다 : ";

    public static Integer getMoneyInputForVendingMachine() {
        System.out.println(REQUEST_MESSAGE_FOR_INITIAL_MONEY_OF_VENDINGMACHINE);
        String initialMoney = Console.readLine();

        try {
            validateMoneyInput(initialMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoneyInputForVendingMachine();
        }

        return Integer.parseInt(initialMoney);
    }

    private static void validateMoneyInput(String initialMoney) {
        if (!initialMoney.matches(REGEX_FOR_NUMBERS)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_MONEY_INPUT);
        }
    }

    public static String getProductInput() {
        System.out.println(REQUEST_MESSAGE_FOR_PRODUCT_INFO);
        String productInput = Console.readLine();

        try {
            validateProductInput(productInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getProductInput();
        }

        return productInput;
    }

    private static void validateProductInput(String productInput) {
        Arrays.stream(productInput.split(DELIMITER_OF_PRODUCT_LIST_INFO))
                .forEach(e -> {
                    String price = e.split(DELIMITER_OF_SINGLE_PRODUCT_INFO)[INDEX_OF_PRICE];
                    validateNumberFormat(price);
                    validateMinimumPrice(price);
                    validatePriceUnit(price);
                });
    }

    private static void validatePriceUnit(String price) {
        if (Integer.parseInt(price) % MINIMUM_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_MONEY_UNIT + price);
        }
    }

    private static void validateMinimumPrice(String e) {
        if (Integer.parseInt(e) < MINIMUM_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_TOO_LOW_PRICE + e);
        }
    }

    private static void validateNumberFormat(String e) {
        if (!e.matches(REGEX_FOR_NUMBERS)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_MONEY_INPUT);
        }
    }

    public static int getMoneyInputForPurchase() {
        System.out.println(REQUEST_MESSAGE_FOR_MONEY_INPUT_TO_PURCHASE);
        String inputMoney = Console.readLine();

        try {
            validateNumberFormat(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoneyInputForPurchase();
        }

        return Integer.parseInt(inputMoney);
    }

    public static String getProductToPurchase(Products products) {
        System.out.println(REQUEST_MESSAGE_FOR_PRODUCT_NAME_TO_PURCHASE);
        String product = Console.readLine();

        if (products.isServiceableProduct(product)) {
            return product;
        }

        System.out.printf(ERROR_MESSAGE_FOR_INVALID_PRODUCT_NAME, product);
        return getProductToPurchase(products);
    }
}
