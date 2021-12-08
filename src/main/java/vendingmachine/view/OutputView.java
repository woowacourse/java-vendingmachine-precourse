package vendingmachine.view;

import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.enums.Coin;

import java.util.ArrayList;
import java.util.Map;

public class OutputView {
    public static final String PRINT_LEFT_COINS = "자판기가 보유한 동전";
    public static final String PRINT_NO_CHANGES = "잔돈이 존재하지 않습니다.";
    public static final String PRINT_LEFT_INSERT_MONEY = "투입 금액: ";
    public static final String PRINT_CHANGE_COINS = "잔돈";
    public static final String PRINT_COUNT_UNIT = "개";

    public static void printSystemMessage(String message) {
        System.out.println(message);
    }

    public static void printVendingMachineChanges(VendingMachine vendingMachine) {
        System.out.println(PRINT_LEFT_COINS);
        Map<Coin, Integer> coinMap = vendingMachine.getChanges().getCoinMap();
        printChanges(coinMap);
    }

    public static void printInsertMoney(VendingMachine vendingMachine) {
        System.out.println(PRINT_LEFT_INSERT_MONEY + vendingMachine.getMoney());
    }

    public static void printVendingMachineReturnChanges(VendingMachine vendingMachine) {
        System.out.println(PRINT_CHANGE_COINS);
        Map<Coin, Integer> returnChanges = vendingMachine.getReturnChanges();
        if (returnChanges == null) {
            System.out.println(PRINT_NO_CHANGES);
            return;
        }
        printChanges(returnChanges);
    }

    private static void printChanges(Map<Coin, Integer> returnChanges) {
        new ArrayList<>(returnChanges.keySet())
                .forEach(coin ->
                        System.out.println(coin.toString() + returnChanges.get(coin) + PRINT_COUNT_UNIT));
    }

    public static void breakLine() {
        System.out.println();
    }
}
