package vendingmachine.controller;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.utils.Exception;
import vendingmachine.utils.NumberValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputController {

    public static void makeProductsList(VendingMachine vendingMachine) {
        String inputProducts = InputView.inputProducts();
        String[] productsInfo = splitProducts(inputProducts, ";");
        if (validateProductForm(productsInfo) && validateDuplicate(productsInfo)) {
            for (String productInfo : sliceProduct(productsInfo)) {
                processOfAddingProduct(vendingMachine, splitProducts(productInfo, ","));
            }
        }
    }

    private static void processOfAddingProduct(VendingMachine vendingMachine, String[] individualProduct) {
        if (validateInputProduct(individualProduct)) {
            String productName = individualProduct[0];
            int productPrice = Integer.parseInt(individualProduct[1]);
            int productQuantity = Integer.parseInt((individualProduct[2]));
            vendingMachine.addProduct(new Product(productName, productPrice, productQuantity));
        }
    }

    private static boolean validateInputProduct(String[] individualProduct) {
        return validateProductPrice(individualProduct[1]) && validateProductQuantity(individualProduct[2]);
    }

    public static boolean validateProductForm(String[] productsInfo) {
        if (!checkInputForm(productsInfo)) {
            throw new IllegalArgumentException(Exception.PRODUCT_INPUT_FORM_EXCEPTION_MESSAGE);
        }
        return true;
    }

    private static boolean checkInputForm(String[] productsInfo) {
        for (String productInfo : productsInfo) {
            if (productInfo.indexOf("[") != 0) {
                return false;
            }
            if (productInfo.indexOf("]") != productInfo.length() - 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateDuplicate(String[] productsInfo) {
        if (checkDuplicateName(productsInfo)) {
            throw new IllegalArgumentException(Exception.PRODUCT_NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
        return true;
    }

    private static boolean checkDuplicateName(String[] productsInfo) {
        List<String> productNames = new ArrayList<>();
        for (String productInfo : sliceProduct(productsInfo)) {
            productNames.add(splitProducts(productInfo, ",")[0]);
        }
        if (productNames.size() != productNames.stream().distinct().count()) {
            System.out.println("중복입니다.");
            return true;
        }
        return false;
    }

    public static boolean validateProductPrice(String price) {
        if (!NumberValidator.validateNumber(price)) {
            throw new IllegalArgumentException(Exception.PRODUCT_PRICE_NUMBER_EXCEPTION_MESSAGE);
        } else if (!NumberValidator.validateZeroNumber(price)) {
            throw new IllegalArgumentException(Exception.PRODUCT_PRICE_ZERO_EXCEPTION_MESSAGE);
        }
        return true;
    }

    public static boolean validateProductQuantity(String quantity) {
        if (!NumberValidator.validateNumber(quantity)) {
            throw new IllegalArgumentException(Exception.PRODUCT_QUANTITY_NUMBER_EXCEPTION_MESSAGE);
        } else if (!NumberValidator.validateZeroNumber(quantity)) {
            throw new IllegalArgumentException(Exception.PRODUCT_QUANTITY_ZERO_EXCEPTION_MESSAGE);
        }
        return true;
    }

    private static String[] splitProducts(String inputProducts, String delimiter) {
        return inputProducts.split(delimiter);
    }

    private static List<String> sliceProduct(String[] products) {

        return Arrays.stream(products).
                map(product -> product.substring(1, product.length() - 1))
                .collect(Collectors.toList());
    }
}
