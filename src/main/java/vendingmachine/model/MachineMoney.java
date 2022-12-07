package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MachineMoney {

    private final Map<Coin, Integer> machineMoney;

    private MachineMoney(Map<Coin, Integer> machineMoney) {
        this.machineMoney = machineMoney;
    }

    public static MachineMoney from(int money) {
        return new MachineMoney(createRandomCoins(money));
    }

    private static Map<Coin, Integer> createRandomCoins(int money) {
        Map<Coin, Integer> machine = new EnumMap<>(Coin.class);
        while (money > 0) {
            int randomCoin = Randoms.pickNumberInList(getCoinUnits());
            if (randomCoin <= money) {
                money -= randomCoin;
                machine.put(Coin.from(randomCoin), machine.getOrDefault(Coin.from(randomCoin), 0) + 1);
            }
        }
        return machine;
    }

    private static List<Integer> getCoinUnits() {
        return Arrays.stream(Coin.values())
                .map(value -> value.getAmount())
                .collect(Collectors.toList());
    }


}
