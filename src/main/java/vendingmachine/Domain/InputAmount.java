package vendingmachine.Domain;

import vendingmachine.Constant.OutputConstant;

public class InputAmount {
    private static int inputAmount;

    private InputAmount() {
        inputAmount = 0;
    }

    public static void inputMoney(int amount) {
        inputAmount += amount;
    }

    public static void takeMoney(int cost) {
        inputAmount -= cost;
    }

    public static boolean isMoreThanCost(int cost) {
        return inputAmount >= cost;
    }

    public static String printInputAmount() {
        return OutputConstant.PRINT_INPUT_AMOUNT + inputAmount + OutputConstant.INPUT_AMOUNT;
    }


}
