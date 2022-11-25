package vendingmachine;

import static java.util.Arrays.*;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private static final List<Integer> amountList = stream(Coin.values()).map(value -> value.amount)
            .collect(Collectors.toList());

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Map<Integer, Integer> getVendingMachineCoins(int vendingMachineCoin) {
        Map<Integer, Integer> vendingMachineCoins  = new TreeMap<>(Collections.reverseOrder());
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
