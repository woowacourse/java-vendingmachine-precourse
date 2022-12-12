package vendingmachine.controller;

import vendingmachine.model.Balance;
import vendingmachine.model.Product;
import vendingmachine.model.Validator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static vendingmachine.model.Validator.validateProduct;

public class VendingMachineController {

    private static Balance balance;
    private static Map<String, Product> products;
    private static int amountOfInput;

    public void setVendingMachine() {
        balance = new Balance(InputView.readBalance());
        OutputView.printBalanceCoin(balance.createCoin());
        saveProducts();
        amountOfInput = InputView.readAmountOfInput();
        OutputView.printAmountOfInput(amountOfInput);
    }

    public void runVendingMachine() {
        while (canBuy()) {
            buy();
            OutputView.printAmountOfInput(amountOfInput);
        }
        OutputView.printChange(balance.calculateChangeCoin(amountOfInput));
    }

    private boolean canBuy() {
        List<Integer> leftProductsPrice = new ArrayList<Integer>();
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            if (entry.getValue().stockIsLeft()) {
                leftProductsPrice.add(entry.getValue().getPrice());
            }
        }
        if (leftProductsPrice.isEmpty()) {
            return false;
        }
        return amountOfInput >= leftProductsPrice.stream().mapToInt(Integer::intValue).min().getAsInt();
    }


    public void saveProducts() throws IllegalArgumentException {
        products = new HashMap<>();
        try {
            String[] str = InputView.readProductInfo().split(";");
            for (String s : str) {
                String[] productInfo = s.substring(1, s.length() - 1).split(",");
                validateProduct(productInfo, products);
                products.put(productInfo[0], new Product(productInfo[1], productInfo[2]));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            saveProducts();
        }
    }


    private void buy() {
        try {
            String buyingProduct = InputView.readBuyingProduct();
            Validator.validateBuyingProduct(buyingProduct, products, amountOfInput);
            amountOfInput -= products.get(buyingProduct).getPrice();
            products.get(buyingProduct).reduceAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buy();
        }
    }
}

