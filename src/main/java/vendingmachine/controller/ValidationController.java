package vendingmachine.controller;

import vendingmachine.domain.Product;

import java.util.Arrays;
import java.util.HashSet;

public class ValidationController {
    public static void vendingMachineValidation(String input) {
        isNumValidation(input);
        positiveIntegerValidation(input);
        divided10Validation(input);
    }

    private static void divided10Validation(String input) {
        int checkNum = Integer.parseInt(input);
        if (checkNum % 10 != 0){
            throw new IllegalArgumentException("[ERROR] 10으로 나눠지지 않습니다.");
        }
    }

    private static void positiveIntegerValidation(String input) {
        int checkNum = Integer.parseInt(input);
        if (checkNum <= 0){
            throw new IllegalArgumentException("[ERROR] 양의 정수가 아닙니다.");
        }
    }

    private static void isNumValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    public static void productValidation(String productInfo) {
        String[] productData = productInfo.split(";");
        bracketsValidation(productData);
        removeBrackets(productData);
        commaValidation(productData);
        blankValidation(productData);
    }

    private static void removeBrackets(String[] productData) {
        for (int i = 0; i<productData.length; i++){
            productData[i] = productData[i].substring(1, productData[i].length()-1);
        }
    }

    private static void commaValidation(String[] productData) {
        for (String productDatum : productData) {
            if (countChar(productDatum, ',') != 2){
                throw new IllegalArgumentException("[ERROR] 두 개의 콤마가 아닙니다.");
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
            if (!(productDatum.charAt(0) == '[' && productDatum.charAt(productDatum.length()-1) == ']')){
                throw new IllegalArgumentException("[ERROR] 양 끝이 대괄호가 아닙니다.");
            }
        }
    }

    private static void blankValidation(String[] productData) {
        for (String productDatum : productData) {
            String[] splitData = productDatum.split(",");
            if (splitData.length != 3){
                throw new IllegalArgumentException("[ERROR] 잘못된 구조의 입력입니다.");
            }
        }
    }

    public static void duplicateValidation(String productInfo) {
        String[] productData = productInfo.split(";");
        HashSet<String> checkProductName = new HashSet<>();

        for (String productDatum : productData) {
            String[] productSplitData = productDatum.split(",");
            checkProductName.add(productSplitData[0].substring(1,productSplitData[0].length()));
        }

        if (productData.length != checkProductName.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 상품명 입력이 있습니다.");
        }
    }

    public static void productAmountValidation(String productInfo) {
        String[] productData = productInfo.split(";");

        for (String productDatum : productData) {
            String[] productSplitData = productDatum.split(",");
            isNumValidation(productSplitData[1]);
            positiveIntegerValidation(productSplitData[1]);
            divided10Validation(productSplitData[1]);
            under100Validation(productSplitData[1]);
        }
    }

    private static void under100Validation(String input) {
        int checkNum = Integer.parseInt(input);
        if (checkNum < 100){
            throw new IllegalArgumentException("[ERROR] 100 미만의 수 입니다.");
        }
    }

    public static void quantityValidation(String productInfo) {
        String[] productData = productInfo.split(";");

        for (String productDatum : productData) {
            String[] productSplitData = productDatum.split(",");
            String checkStr = productSplitData[2].substring(0, productSplitData[2].length()-1);
            isNumValidation(checkStr);
            positiveIntegerValidation(checkStr);
        }
    }

    public static void purchaseValidation(Product product, String productName) {
        if (!product.hasInProduct(productName)){
            throw new IllegalArgumentException("[ERROR] 없는 상품명입니다.");
        }
    }
}
