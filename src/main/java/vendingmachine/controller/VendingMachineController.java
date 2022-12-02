package vendingmachine.controller;

import vendingmachine.model.Balance;
import vendingmachine.model.Product;
import vendingmachine.model.Validator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class VendingMachineController {

    private static Map<String, Product> products = new HashMap<>();
    private static int amountOfInput;

    private static boolean canBuy() {
        List<Integer> leftProductsPrice = new ArrayList<Integer>();
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            if (entry.getValue().amount != 0) {
                leftProductsPrice.add(entry.getValue().price.get());
            }
        }
        Collections.sort(leftProductsPrice);
        if (leftProductsPrice.isEmpty()) {
            return false;
        }
        return amountOfInput >= leftProductsPrice.get(0);
    }

    private static void buy() {
        try {
            String buyingProduct = InputView.readBuyingProduct();
            Validator.validateBuyingProduct(buyingProduct, products, amountOfInput);
            amountOfInput -= products.get(buyingProduct).price.get();
            products.get(buyingProduct).amount--;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            buy();
        }
    }

    public static void saveProducts() {
        try {
            String input = InputView.readProductInfo();
            String[] str = input.split(";");
            for (String s : str) {
                String[] productInfo = s.substring(1, s.length() - 1).split(",");
                Validator.validateProduct(productInfo, products);
                products.put(productInfo[0], new Product(productInfo[1], productInfo[2]));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            products = new HashMap<>();
            saveProducts();
        }
    }
}

