package vendingmachine;

import static java.util.Arrays.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private static final List<Integer> amountList = stream(Coin.values()).map(value -> value.amount)
            .collect(Collectors.toList());
    private final int amount;
    private final int count;

    Coin(final int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public static Map<Integer, Integer> initVendingMachineCoins(int vendingMachineCoin) {
        Map<Integer, Integer> vendingMachineCoins  = new TreeMap<>(Collections.reverseOrder());
        for (Coin coin : Coin.values()) {
            vendingMachineCoins.put(coin.amount, coin.count);
        }
        return getVendingMachineCoins(vendingMachineCoin, vendingMachineCoins);
    }

    public static Map<Integer, Integer> getVendingMachineCoins(int vendingMachineCoin, Map<Integer, Integer> vendingMachineCoins) {
        while (vendingMachineCoin > 0) {
            int amount = Randoms.pickNumberInList(amountList);
            if (vendingMachineCoin >= amount) {
                vendingMachineCoins.put(amount, vendingMachineCoins.getOrDefault(amount, 0) + 1);
                vendingMachineCoin -= amount;
            }
        }
        return vendingMachineCoins;
    }
}