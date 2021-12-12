package vendingmachine;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {

    private static final String PRODUCT_SEPARATOR = ";";
    private static final String PROPERTY_SEPARATOR = ",";
    private static final int NAME = 0;
    private static final int PRICE = 1;
    private static final int COUNT = 2;

    public Map<Coin, Integer> convertToCoins(int money) {
        Map<Coin, Integer> coins = new LinkedHashMap<>();

        for (Coin coin : Coin.values()) {
            if (money / coin.getAmount() >= 1) {
                coins.put(coin, money / coin.getAmount());
                money = money % coin.getAmount();
                continue;
            }
            coins.put(coin, 0);
        }

        return coins;
    }

    public List<Product> convertToProducts(String input) {
        return Arrays.stream(input.split(PRODUCT_SEPARATOR))
            .map(productInfo -> productInfo.substring(1, productInfo.length() - 1))
            .map(productInfo -> productInfo.split(PROPERTY_SEPARATOR))
            .map(productInfo ->
                new Product(productInfo[NAME],
                    Integer.parseInt(productInfo[PRICE]),
                    Integer.parseInt(productInfo[COUNT])))
            .collect(Collectors.toList());
    }

    public List<String> convertToProductNames(String input) {
        return Arrays.stream(input.split(PRODUCT_SEPARATOR))
            .map(productInfo -> productInfo.substring(1, productInfo.length() - 1))
            .map(productInfo -> productInfo.split(PROPERTY_SEPARATOR))
            .map(productInfo -> productInfo[NAME])
            .collect(Collectors.toList());
    }

    public List<String> convertToProductPrices(String input) {
        return Arrays.stream(input.split(PRODUCT_SEPARATOR))
            .map(productInfo -> productInfo.substring(1, productInfo.length() - 1))
            .map(productInfo -> productInfo.split(PROPERTY_SEPARATOR))
            .map(productInfo -> productInfo[PRICE])
            .collect(Collectors.toList());
    }

    public List<String> convertToProductCounts(String input) {
        return Arrays.stream(input.split(PRODUCT_SEPARATOR))
            .map(productInfo -> productInfo.substring(1, productInfo.length() - 1))
            .map(productInfo -> productInfo.split(PROPERTY_SEPARATOR))
            .map(productInfo -> productInfo[COUNT])
            .collect(Collectors.toList());
    }
}
