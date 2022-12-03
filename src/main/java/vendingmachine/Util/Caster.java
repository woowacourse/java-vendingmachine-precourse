package vendingmachine.Util;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Domain.Change;
import vendingmachine.Domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static vendingmachine.Constant.Coin.*;

public class Caster {

    public Change toChangeCoins(int money) {
        HashMap<Integer, Integer> coins = new HashMap<>();

        coins.put(COIN_10.getAmount(), 0);
        coins.put(COIN_50.getAmount(), 0);
        coins.put(COIN_100.getAmount(), 0);
        coins.put(COIN_500.getAmount(), 0);

        return createRandomCoins(coins, money);
    }

    private Change createRandomCoins(HashMap<Integer, Integer> coins, int money) {
        List<Integer> coinKeys = new ArrayList<>(coins.keySet());
        int randomCost = Randoms.pickNumberInList(coinKeys);
        int sum = getCoinsCostSum(coins);

        while (sum != money) {
            if (sum + randomCost <= money) {
                coins.put(randomCost, coins.get(randomCost) + 1);
                sum = getCoinsCostSum(coins);
            }
            randomCost = Randoms.pickNumberInList(coinKeys);
        }

        return new Change(coins);
    }

    private int getCoinsCostSum(HashMap<Integer, Integer> coins) {
        List<Integer> coinKeys = new ArrayList<>(coins.keySet());
        int sum = 0;

        for (int key : coinKeys) sum += coins.get(key) * key;

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
        return productInfo
                .split(",")[0]
                .substring(1);
    }

    private int getProductCost(String productInfo) {
        return Integer.parseInt(productInfo
                .split(",")[1]);
    }

    private int getProductCount(String productInfo) {
        String count = productInfo.split(",")[2];
        count = count.substring(0, count.length() - 1);

        return Integer.parseInt(count);
    }

}
