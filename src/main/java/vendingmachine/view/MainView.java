package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class MainView {
    public String askQuestion(InputData data) {
        System.out.println(data);
        return readLine();
    }

    public void printOutput(OutputData data) {
        System.out.println(data);
    }

    public void printCoinStatus(int coinCost, int coinCount) {
        String output = String.valueOf(coinCost)
            + OutputData.COIN_UNIT + " "
            + OutputData.COIN_DIVIDER + " "
            + coinCount
            + OutputData.COIN_COUNT;
        System.out.println(output);
    }

    public void printInputMoneyStatus(int inputMoneyNow) {
        String output = OutputData.INPUT_MONEY_LEFT + " "
            + inputMoneyNow + OutputData.COIN_UNIT;
        System.out.println(output);
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printError(Exception exception) {
        System.out.println(OutputData.ERROR + " " + exception.getMessage());
    }
}
