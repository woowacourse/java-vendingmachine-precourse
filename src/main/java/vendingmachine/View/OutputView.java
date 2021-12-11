package vendingmachine.View;

import vendingmachine.constant.SystemMessage;
import vendingmachine.domain.enums.Coin;
import vendingmachine.domain.vendingMachine.VendingMachine;

import java.util.ArrayList;

public class OutputView {
    final static String INPUT_MONEY_MESSAGE = "투입 금액: ";

    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printCoinStatus(Coin coin) {
        System.out.println(SystemMessage.COIN_STATUS_MESSAGE.print());
        for (Coin c : coin.values()) {
            System.out.println(c.toString());
        }
    }

    public static void printMoneyStatus(VendingMachine vendingMachine) {
        System.out.println(INPUT_MONEY_MESSAGE + vendingMachine.getInputMoney());
    }

    public static void printChange(ArrayList<String> changeList) {
        changeList.stream()
                .forEach(System.out::println);
    }
}
