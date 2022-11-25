package vendingmachine.view;

import java.util.Map;

public class OutputView {

    public void printVendingMachineCoins(Map<Integer, Integer> vendingMachineCoins) {
        vendingMachineCoins.forEach((key, value) -> System.out.println(key + "원 - " + value + "개"));
    }

}
