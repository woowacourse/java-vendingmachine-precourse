package vendingmachine;

import static vendingmachine.domain.Coin.COIN_10;
import static vendingmachine.domain.Coin.COIN_100;
import static vendingmachine.domain.Coin.COIN_50;
import static vendingmachine.domain.Coin.COIN_500;
import static vendingmachine.domain.Coin.coinMapper;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;

public class CoinMaker {

    public static EnumMap<Coin, Integer> generateCoins(Money machineMoney) {
        List<Integer> totalCoins = Arrays
                .asList(COIN_500.amount(), COIN_100.amount(), COIN_50.amount(), COIN_10.amount());
        EnumMap<Coin, Integer> coinCount = initCoinMap();

        generate(machineMoney, totalCoins, coinCount);

        return coinCount;
    }

    private static void generate(Money machineMoney, List<Integer> totalCoins, EnumMap<Coin, Integer> coinCount) {
        int curAmount = 0;
        while (curAmount != machineMoney.getAmount()) {
            int newCoin = Randoms.pickNumberInList(totalCoins);
            if (isLessOrSame(newCoin, curAmount, machineMoney.getAmount())) {
                curAmount += newCoin;
                Coin keyCoin = coinMapper(newCoin);
                coinCount.put(keyCoin, coinCount.get(keyCoin) + 1);
            }
        }
    }

    private static boolean isLessOrSame(int newCoin, int curAmount, int machineMoney){
        if (newCoin + curAmount <= machineMoney) {
            return true;
        }
        return false;
    }

    private static EnumMap<Coin, Integer> initCoinMap() {
        EnumMap<Coin, Integer> coinMap = new EnumMap<>(Coin.class);
        coinMap.put(COIN_500, 0);
        coinMap.put(COIN_100, 0);
        coinMap.put(COIN_50, 0);
        coinMap.put(COIN_10, 0);

        return coinMap;
    }
}
