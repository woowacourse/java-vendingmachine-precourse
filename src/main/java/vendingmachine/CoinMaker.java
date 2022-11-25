package vendingmachine;

import static vendingmachine.Coin.COIN_10;
import static vendingmachine.Coin.COIN_100;
import static vendingmachine.Coin.COIN_50;
import static vendingmachine.Coin.COIN_500;
import static vendingmachine.Coin.coinMapper;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class CoinMaker {

    public static EnumMap<Coin, Integer> generateCoins(Money machineMoney) {
        List<Integer> totalCoins = Arrays
                .asList(COIN_500.amount(), COIN_100.amount(), COIN_50.amount(), COIN_10.amount());
        EnumMap<Coin, Integer> coinCount = initCoinMap();

        int curAmount = 0;
        while (true){
            if (curAmount == machineMoney.getAmount()){
                break;
            }

            int newCoin = Randoms.pickNumberInList(totalCoins);
            if (isLessOrSame(newCoin, curAmount, machineMoney.getAmount())) {
                curAmount += newCoin;
                Coin keyCoin = coinMapper(newCoin);
                coinCount.put(keyCoin, coinCount.get(keyCoin) + 1);
            }
        }
        return coinCount;
    }

    private static boolean isLessOrSame(int newCoin, int curAmount, int machineMoney){
        if (newCoin + curAmount <= machineMoney) {
            return true;
        }
        return false;
    }

    private static EnumMap<Coin, Integer> initCoinMap() {
        return new EnumMap<>(
                Map.of(
                        COIN_500, 0,
                        COIN_100, 0,
                        COIN_50, 0,
                        COIN_10, 0)
        );
    }
}
