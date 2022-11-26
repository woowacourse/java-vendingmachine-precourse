package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import constant.ErrorLog;
import util.Validator;

public class Products {
    private final HashMap<HashMap<String, Integer>, Integer> products = new HashMap<>();

    public Products(List<String> productsInfo) {
        List<List<String>> products = new ArrayList<>();
        productsInfo.forEach(
            product -> products.add(
                Arrays.stream(product.substring(1, product.length() - 1).split(",")).collect(Collectors.toList())));
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

    public int purchase(String product) {
        AtomicInteger price = new AtomicInteger();
        if (products.keySet().stream().noneMatch(productInfo -> productInfo.containsKey(product))) {
            throw new IllegalArgumentException(ErrorLog.NOT_IN_PRODUCT_LIST.getLog());
        }
        products.forEach((productInfo, number) -> {
            if (productInfo.containsKey(product)) {
                Validator.validateNotZero(number);
                products.replace(productInfo, number - 1);
                price.set(productInfo.get(product));
            }
        });
        return price.intValue();
    }

    public boolean noStock() {
        return products.values().stream().allMatch(number -> number == 0);
    }

    public int minimumPrice() {
        List<Integer> prices = new ArrayList<>();
        products.keySet().forEach(productInfo -> prices.add(productInfo.values().stream().iterator().next()));
        return Collections.min(prices);
    }
}
