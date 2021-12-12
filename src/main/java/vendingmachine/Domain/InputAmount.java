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

    public static boolean isMoreThanNum(int num) {
        return inputAmount >= num;
    }

    public static int calculateMaxNumber(Coin c) {
        return inputAmount / c.getAmount();
    }

    public static String printInputAmount() {
        return OutputConstant.PRINT_INPUT_AMOUNT + inputAmount + OutputConstant.INPUT_AMOUNT;
    }


}
