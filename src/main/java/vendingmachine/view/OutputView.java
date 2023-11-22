package vendingmachine.view;

import java.util.List;

import static vendingmachine.view.constants.ErrorMessage.ERROR_TAG;
import static vendingmachine.view.constants.OutputMessage.ASK_DRINKS;
import static vendingmachine.view.constants.OutputMessage.ASK_TOTAL_MONEY_OF_VENDING_MACHINE;
import static vendingmachine.view.constants.OutputMessage.ASK_USER_INPUT_MONEY;
import static vendingmachine.view.constants.OutputMessage.SHOW_VENDING_MACHINE_COINS;
import static vendingmachine.view.constants.OutputMessage.SHOW_VENDING_MACHINE_HOLD_COIN_START_TAG;

public class OutputView {
    public static void askMachineTotalMoney(){
        print(ASK_TOTAL_MONEY_OF_VENDING_MACHINE);
    }

    public static void printVendingMachineCoins(List<Integer> coinCounts){
        print(SHOW_VENDING_MACHINE_HOLD_COIN_START_TAG);
        print(String.format(SHOW_VENDING_MACHINE_COINS,
                coinCounts.get(0),
                coinCounts.get(1),
                coinCounts.get(2),
                coinCounts.get(3)
        ));
    }

    public static void askDrinkFromUsers() {
        print(ASK_DRINKS);
    }

    public static void askUserInputMoney() {
        print(ASK_USER_INPUT_MONEY);
    }

    private static void print(String message){
        System.out.println(message);
    }

    public static void errorMessage(String errorMessage) {
        System.out.println(ERROR_TAG + errorMessage);
    }
}
