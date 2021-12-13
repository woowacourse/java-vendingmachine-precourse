package vendingmachine.controller;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputController {

    public static void makeProductsList(VendingMachine vendingMachine) {
        String inputProducts = InputView.inputProducts();

        for (String productInfo : sliceProduct(splitProducts(inputProducts, ";"))) {
            String[] individualProduct = splitProducts(productInfo, ",");
            String productName = individualProduct[0];
            int productPrice = Integer.parseInt(individualProduct[1]);
            int productQuantity = Integer.parseInt((individualProduct[2]));
            vendingMachine.addProduct(new Product(productName, productPrice, productQuantity));
        }
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
