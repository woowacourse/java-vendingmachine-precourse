package vendingmachine.view;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Customer;

import java.util.HashMap;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String CHANGE_IN_VENDING_MACHINE_MESSAGE = "자판기가 보유한 동전";
    private static final String PRINT_MONEY_PREFIX = "투입 금액: ";
    private static final String PRINT_MONEY_SUFFIX = "원";
    private static final String PRINT_CHANGE = "잔돈";

    public void printCoinList(Change change) {
        HashMap<Coin, Integer> coinStorage = change.getCoinStorage();
        // 출력 기능 수행
        System.out.println(NEW_LINE + CHANGE_IN_VENDING_MACHINE_MESSAGE);
    }

    public void printMoney(int money) {
        System.out.println(NEW_LINE + PRINT_MONEY_PREFIX + money + PRINT_MONEY_SUFFIX);
    }

    public void printChange(Customer customer) {
        System.out.println(NEW_LINE + PRINT_CHANGE);
    }

    public void printError(String error) {
        System.out.println(error + NEW_LINE);
    }

}
