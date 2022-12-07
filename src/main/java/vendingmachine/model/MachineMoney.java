package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
        Map<Coin, Integer> machine = initializeMachine();
        while (money > 0) {
            int randomCoin = getRandomCoin();
            if (randomCoin <= money) {
                money -= randomCoin;
                machine.put(Coin.from(randomCoin), machine.get(Coin.from(randomCoin)) + 1);
            }
        }
        return machine;
    }

    private static Map<Coin, Integer> initializeMachine() {
        Map<Coin, Integer> machine = new EnumMap<>(Coin.class);
        Arrays.stream(Coin.values()).forEach(coin -> machine.put(coin, 0));
        return machine;
    }

    private static int getRandomCoin() {
        return Randoms.pickNumberInList(getCoinUnits());
    }

    private static List<Integer> getCoinUnits() {
        return Arrays.stream(Coin.values())
                .map(value -> value.getAmount())
                .collect(Collectors.toList());
    }

    public Map<Coin, Integer> getLeftMoney(int leftMoney) {
        Map<Coin, Integer> leftMachineToCoin = new EnumMap<>(Coin.class);
        for (Map.Entry<Coin, Integer> element : machineMoney.entrySet()) {
            int unit = element.getKey().getAmount();
            int amount = getAmount(leftMoney, element, unit);
            leftMoney -= unit * amount;
            leftMachineToCoin.put(Coin.from(unit), amount);
        }
        return leftMachineToCoin;
    }

    private static int getAmount(int leftMoney, Entry<Coin, Integer> element, int unit) {
        int amount = element.getValue();
        while (leftMoney < unit * amount) {
            amount--;
        }
        return amount;
    }

    public Map<Coin, Integer> getMachineMoney() {
        return machineMoney;
    }
}
