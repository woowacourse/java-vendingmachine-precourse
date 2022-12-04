package vendingmachine.Util;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Constant.Coin;
import vendingmachine.Domain.Change;
import vendingmachine.Domain.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static vendingmachine.Constant.Coin.values;

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

    public List<Product> toProducts(String userInput) {
        List<Product> products = new ArrayList<>();

        for (String productInfo : userInput.split(";")) {
            String name = getProductName(productInfo);
            int cost = getProductCost(productInfo);
            int count = getProductCount(productInfo);

            products.add(new Product(name, cost, count));
        }

        return products;
    }

    private String getProductName(String productInfo) {
        return productInfo.split(",")[0].substring(1);
    }

    private int getProductCost(String productInfo) {
        return Integer.parseInt(productInfo.split(",")[1]);
    }

    private int getProductCount(String productInfo) {
        String count = productInfo.split(",")[2];
        count = count.substring(0, count.length() - 1);

        return Integer.parseInt(count);
    }

}
