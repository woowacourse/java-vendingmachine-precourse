package vendingmachine.view;

import java.util.Map;

public class OutputView {

    public void printVendingMachineCoins(Map<Integer, Integer> vendingMachineCoins) {
        vendingMachineCoins.forEach((key, value) -> System.out.println(key + "원 - " + value + "개"));
    }

    public void printPurchasingProcess(int money) {
        System.out.printf("투입 금액: %d\n", money);
    }

    public void printChargeCoins(Map<Integer, Integer> chargeCoins, int money) {
        printPurchasingProcess(money);
        System.out.println("잔돈");
        printVendingMachineCoins(chargeCoins);
    }
}
