package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Utils {

    private static int MIN_VALUE = 100;
    private static int DIVIDED_VALUE = 10;

    public static ArrayList splitString(String inputString) throws Exception {
        //String[] splits = inputString.replace("[","").replace("]","").split(";");
        String[] splits = inputString.split(";");
        for (int i = 0; i < splits.length; i++) {
            Utils.validateProductInputForm(splits[i]);
            splits[i] = splits[i].substring(1, splits[i].length() - 1);
            System.out.println("_" + splits[i] + "_");
        }
        return new ArrayList<String>(Arrays.asList(splits));
    }

    public static void validateNumber(String str) {
        if (!str.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 금액 혹은 가격, 수량은 숫자여야 합니다.");
        }
    }

    public static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액 혹은 가격, 수량은 0보다 커야합니다.");
        }
    }

    public static void validateOvervalue(int number) {
        if (number < MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR] 상품의 가격은 " + MIN_VALUE + "원 이상이어야 합니다.");
        }
    }

    public static void validateDividableByValue(int number) {
        if (number % DIVIDED_VALUE != 0) {
            throw new IllegalArgumentException("[ERROR] 가격은 최소 10원 단위어야 합니다.");
        }
    }

    public static void validateRegistered(ArrayList<Product> products, String buyProduct) {
        for (Product product : products) {
            if (product.getName().equals(buyProduct)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 등록된 상품이 아닙니다.");
    }

    public static void validateDuplication(ArrayList<Product> products, String name) {
        if ((int) products.stream().filter(p -> p.getName().equals(name)).count() != 0) {
            throw new IllegalArgumentException("[ERROR] 상품은 중복 등록될 수 없습니다.");
        }
    }

    public static void validateStrEmpty(String productName) {
        if (productName.equals("")) {
            throw new IllegalArgumentException("[ERROR] 상품명은 공백이 될 수 없습니다.");
        }
    }

    public static void validateProductInputForm(String inputProduct) {
        if (!checkCommaCount(inputProduct)) {
            throw new IllegalArgumentException("[ERROR] 입력형식에 맞지 않습니다.");
        }
        if (!checkSquareBrackets(inputProduct)) {
            throw new IllegalArgumentException("[ERROR] 입력형식에 맞지 않습니다라닫닫.");
        }
    }

    public static boolean checkCommaCount(String inputProduct) {
        int commaCount = 0;
        for (int i = 0; i < inputProduct.length(); i++) {
            if (inputProduct.charAt(i) == ',') {
                commaCount++;
            }
        }
        if (commaCount != 2) {
            return false;
        }
        return true;
    }

    public static boolean checkSquareBrackets(String inputProduct) {
        if (inputProduct.charAt(0) != '[' || inputProduct.charAt(inputProduct.length() - 1) != ']') {
            return false;
        }
        return true;
    }

    public static void validateNameCommon(ArrayList<Product> products, String name) throws Exception {
        validateDuplication(products, name);
        validateStrEmpty(name);
    }

    public static void validatePriceCommon(String price) throws Exception {
        Utils.validateNumber(price);
        Utils.validatePositiveNumber(Integer.parseInt(price));
        Utils.validateOvervalue(Integer.parseInt(price));
        Utils.validateDividableByValue(Integer.parseInt(price));
    }

    public static void validateCountCommon(String count) throws Exception {
        Utils.validateNumber(count);
        Utils.validatePositiveNumber(Integer.parseInt(count));
    }
}
