package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public static Coins setCoins(int initialMoney) {
        Map<Coin, Integer> coins = getInitialMap();
        calculateCoins(coins, initialMoney);
        return new Coins(coins);
    }

    private static Map<Coin, Integer> getInitialMap() {
        Map<Coin, Integer> coins = new LinkedHashMap<>();
        coins.put(Coin.COIN_500, 0);
        coins.put(Coin.COIN_100, 0);
        coins.put(Coin.COIN_50, 0);
        coins.put(Coin.COIN_10, 0);
        return coins;
    }

    private static void calculateCoins(Map<Coin, Integer> coins, int initialMoney) {
        List<Integer> coinAmountList = getCoinList();

        while (initialMoney > 0) {
            int amount = Randoms.pickNumberInList(coinAmountList);
            Coin coin = Coin.getCoinByAmount(amount);

            coins.put(coin, coins.get(coin) + 1);
            initialMoney -= amount;
        }
    }

    private static List<Integer> getCoinList() {
        List<Integer> coinList = new ArrayList<>();
        coinList.add(Coin.COIN_500.getAmount());
        coinList.add(Coin.COIN_100.getAmount());
        coinList.add(Coin.COIN_50.getAmount());
        coinList.add(Coin.COIN_10.getAmount());
        return coinList;
    }

    private static int getCoinNumber(Coin coin, int money) {
        int coinsNumbers = money / coin.getAmount();
        return coinsNumbers;
    }

    public String getChangeMessage(int money) {
        StringBuilder messageBuilder = new StringBuilder();

        AtomicInteger moneyForReturn = new AtomicInteger(money);
        coins.forEach((coin, amount) -> {
            int coinNumber = getCoinNumber(coin, moneyForReturn.get());
            int min = Math.min(coins.get(coin), coinNumber);
            if (min > 0) {
                messageBuilder.append(coin.getCoinInfo(min));
                moneyForReturn.addAndGet(-(min * coin.getAmount()));
            }
        });

        return messageBuilder.toString();
    }
}
