package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.enums.Coin;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Money {
    private static final List<Integer> AMOUNT_LIST = Coin.getAmountList();
    private static final int DEFALUT_CNT = 0;
    private static final int DEFALUT_TOTAL = 0;
    private static final String REST_MONEY_SENTENCE = "잔돈";
    private static final String VENDINGMACHINE_COIN_SENTENCE = "자판기가 보유한 동전";
    private static final String REST_MONEY_SEPARATOR = " - ";
    private static final String REST_MONEY_UNIT = "개";
    private static final String LINE_BREAKER = "\n";

    private Map<Coin, Integer> coins = new LinkedHashMap<>();

    public Money(int total) {
        initialMap();
        setRandomCnt(total);
    }

    public String getChangesString(int total) {
        Map<Coin, Integer> changes = new LinkedHashMap<>();

        for (Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin coin = entry.getKey();
            int cnt = getMaxCntByTotal(coin.getAmount(), entry.getValue(), total);
            changes.put(coin, cnt);
            coins.put(coin, coins.get(coin) - cnt);
            total -= cnt * entry.getValue();
            if (total <= DEFALUT_TOTAL) {
                break;
            }
        }
        return getChangeString(changes);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(VENDINGMACHINE_COIN_SENTENCE);
        for (Entry<Coin, Integer> coin : coins.entrySet()) {
            stringBuilder.append(LINE_BREAKER)
                    .append(coin.getKey().toString())
                    .append(REST_MONEY_SEPARATOR)
                    .append(coin.getValue())
                    .append(REST_MONEY_UNIT);
        }
        return stringBuilder.toString();
    }

    private String getChangeString(Map<Coin, Integer> coins) {
        StringBuilder stringBuilder = new StringBuilder(REST_MONEY_SENTENCE);
        for (Entry<Coin, Integer> coin : coins.entrySet()) {
            stringBuilder.append(LINE_BREAKER)
                    .append(coin.getKey().toString())
                    .append(REST_MONEY_SEPARATOR)
                    .append(coin.getValue())
                    .append(REST_MONEY_UNIT);
        }
        return stringBuilder.toString();
    }

    private int getMaxCntByTotal(int amount, int cnt, int total) {
        int maxCnt = (int) Math.floor((double) total / amount);
        return Math.min(maxCnt, cnt);
    }

    private void initialMap() {
        for (Coin value : Coin.values()) {
            coins.put(value, DEFALUT_CNT);
        }
    }

    private void setRandomCnt(int total) {
        int temp = DEFALUT_TOTAL;
        while (temp != total) {
            int random = Randoms.pickNumberInList(AMOUNT_LIST);
            if (random + temp > total) {
                continue;
            }
            Coin coin = Coin.findNameByValue(random);
            if (coin == null) {
                continue;
            }
            coins.put(coin, coins.getOrDefault(coin, DEFALUT_CNT) + 1);
            temp += random;
        }
    }

}
