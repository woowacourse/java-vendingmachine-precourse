package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;
import vendingmachine.domain.constant.Coin;
import vendingmachine.domain.constant.Product;

public class VendingMachine {
    private final EnumMap<Coin, Integer> vmCoinMap;
    private final Map<String, Product> productMap;

    private VendingMachine(EnumMap<Coin, Integer> vmCoinMap, Map<String, Product> productMap) {
        this.vmCoinMap = vmCoinMap;
        this.productMap = productMap;
    }

    // Static Factory Method
    public static VendingMachine from(final EnumMap<Coin, Integer> vmCoinMap, final Map<String, Product> productMap) {
        return new VendingMachine(vmCoinMap, productMap);
    }

}
