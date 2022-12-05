package vendingmachine.Util;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Constant.Coin;
import vendingmachine.Domain.Change;
import vendingmachine.Domain.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static vendingmachine.Constant.Coin.values;
import static vendingmachine.Constant.ProductConstant.*;
import static vendingmachine.Constant.ProductSeparator.*;

public class Caster {

    public Change toChangeCoins(int money) {
        LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>();

        for (Coin coinUnit : values()) {
            coins.put(coinUnit, 0);
        }

        return createRandomCoins(coins, money);
    }

    private Change createRandomCoins(LinkedHashMap<Coin, Integer> coins, int money) {
        List<Integer> coinUnits = getCoinUnits(coins);
        int sum = getCoinsCostSum(coins);

        while (sum != money) {
            int randomCost = Randoms.pickNumberInList(coinUnits);
            sum = getCoinsCostSum(coins);

            if (sum + randomCost <= money) {
                Coin randomCoin = Coin.getCoinByAmount(randomCost);
                coins.put(randomCoin, coins.get(randomCoin) + 1);
                continue;
            }
            coinUnits = getCoinUnits(coins, randomCost);
        }

        return new Change(coins);
    }

    private List<Integer> getCoinUnits(LinkedHashMap<Coin, Integer> coins) {
        List<Integer> units = new ArrayList<>();

        for (Coin unit : coins.keySet()) {
            units.add(unit.getAmount());
        }

        return units;
    }

    private List<Integer> getCoinUnits(LinkedHashMap<Coin, Integer> coins, int removeTargetUnit) {
        List<Integer> units = new ArrayList<>();

        for (Coin unit : coins.keySet()) {
            if (unit.getAmount() != removeTargetUnit) {
                units.add(unit.getAmount());
            }
        }

        return units;
    }

    private int getCoinsCostSum(LinkedHashMap<Coin, Integer> coins) {
        int sum = 0;

        for (Coin coin : coins.keySet()) sum += coin.getAmount() * coins.get(coin);

        return sum;
    }

    public Product toProducts(String userInput) {
        Product product = new Product();

        userInput = getOrderString(userInput);

        for (String productInfo : userInput.split(ORDER_SEPARATOR.toString())) {
            String name = getProductName(productInfo);
            int price = getProductPrice(productInfo);
            int count = getProductCount(productInfo);

            product.addProduct(name, price, count);
        }

        return product;
    }

    private String getOrderString(String inputOrder) {
        return inputOrder
                .replace(ORDER_PREFIX.toString(), "")
                .replace(ORDER_SUFFIX.toString(), "");
    }

    private String getProductName(String product) {
        return product
                .split(PRODUCT_INFO_SEPARATOR.toString())[PRODUCT_NAME_INDEX.getValue()];
    }

    private int getProductPrice(String product) {
        String price = product.split(PRODUCT_INFO_SEPARATOR.toString())[PRODUCT_PRICE_INDEX.getValue()];
        return Integer.parseInt(price);
    }

    private int getProductCount(String product) {
        String count = product
                .split(PRODUCT_INFO_SEPARATOR.toString())[PRODUCT_COUNT_INDEX.getValue()];
        return Integer.parseInt(count);
    }

}
