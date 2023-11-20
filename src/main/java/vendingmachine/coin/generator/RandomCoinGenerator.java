package vendingmachine.coin.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import vendingmachine.coin.Coin;

public class RandomCoinGenerator implements CoinGenerator{

    @Override
    public Map<Coin, Integer> getCoins(int totalMoney) {
        EnumMap<Coin, Integer> coins = initCoins();
        List<Integer> integers = initIntegers();
        while(totalMoney > 0){
            int amount = Randoms.pickNumberInList(integers);
            if(amount > totalMoney){
                continue;
            }
            Coin coin = Coin.getCoins(amount);
            coins.put(coin, coins.get(coin) + 1);
            totalMoney -= amount;
        }
        return coins;
    }

    private static EnumMap<Coin, Integer> initCoins() {
        EnumMap<Coin, Integer> coins = new EnumMap<>(Coin.class);
        Arrays.stream(Coin.values())
                .forEach(coin -> coins.put(coin, 0));
        return coins;
    }

    private static List<Integer> initIntegers() {
        List<Integer> integers = new ArrayList<>();
        integers.add(500);
        integers.add(100);
        integers.add(50);
        integers.add(10);
        return integers;
    }
}
