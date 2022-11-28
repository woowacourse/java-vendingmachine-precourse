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
        putProductInfo(products);
    }

    private void putProductInfo(List<List<String>> products) {
        products.forEach(info -> {
            HashMap<String, Integer> productInfo = new HashMap<>();
            int price = Integer.parseInt(info.get(1));
            int number = Integer.parseInt(info.get(2));
            validateProductInfo(price, number);
            productInfo.put(info.get(0), price);
            this.products.put(productInfo, number);
        });
    }

    private void validateProductInfo(int price, int number) {
        Validator.validateEnoughMoney(price);
        Validator.validateDivisibleByMinimumMonetaryUnit(price);
        Validator.validateNotZero(number);
    }

    public int purchase(String product, int money) {
        AtomicInteger price = new AtomicInteger();
        validatePurchasing(product, money);
        products.forEach((productInfo, number) -> {
            if (productInfo.containsKey(product)) {
                Validator.validateNotZero(number);
                products.replace(productInfo, number - 1);
                price.set(productInfo.get(product));
            }
        });
        return price.intValue();
    }

    private void validatePurchasing(String product, int money) {
        if (products.keySet().stream().noneMatch(productInfo -> productInfo.containsKey(product))) {
            throw new IllegalArgumentException(ErrorLog.NOT_IN_PRODUCT_LIST.getLog());
        }
        products.keySet().forEach(info -> {
            if (info.containsKey(product) && info.get(product) > money)
                throw new IllegalArgumentException(ErrorLog.NOT_ENOUGH_MONEY.getLog());
        });
    }

    public boolean noStock() {
        return products.values().stream().allMatch(number -> number == 0);
    }

    public int minimumPrice() {
        List<Integer> prices = new ArrayList<>();
        products.keySet().forEach(productInfo -> {
            if (products.get(productInfo) != 0) {
                prices.add(productInfo.values().stream().iterator().next());
            }
        });
        return Collections.min(prices);
    }
}
