package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import util.Validator;

public class Products {
    private HashMap<HashMap<String, Integer>, Integer> products = new HashMap<>();

    public Products(List<String> productsInfo) {
        List<List<String>> products = new ArrayList<>();
        productsInfo.forEach(
            product -> products.add(Arrays.stream(product.replaceAll("[\\[,\\]]", "").split(",")).collect(
                Collectors.toList())));
        products.forEach(info -> {
            HashMap<String, Integer> tmp = new HashMap<>();
            int price = Integer.parseInt(info.get(1));
            int number = Integer.parseInt(info.get(2));
            Validator.validateEnoughMoney(price);
            Validator.validateDivisibleByMinimumMonetaryUnit(price);
            Validator.validateNotZero(number);
            tmp.put(info.get(0), price);
            this.products.put(tmp, number);
        });
    }
}
