package vendingmachine.view;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine.VendingMachine;

public class OutputView {
    public static void printVendingMachineCoins(VendingMachine vendingMachine) {
        System.out.println("자판기가 보유한 동전");
        System.out.println(vendingMachine.getCoinsMessage());
    }

    public static void printMoney(Money money) {
        System.out.printf("투입 금액 : %d원%n", money.getMoney());
    }

    public static void printRest(Money money) {
        System.out.println("잔돈");
        System.out.println(money.getRestMessage());
    }
}
