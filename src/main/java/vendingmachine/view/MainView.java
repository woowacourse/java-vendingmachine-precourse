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
        StringBuilder output = new StringBuilder();
        output.append(coinCost);
        output.append(OutputData.COIN_UNIT);
        output.append(OutputData.COIN_DIVIDER);
        output.append(coinCount);
        output.append(OutputData.COIN_COUNT);
        System.out.println(output);
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printError() {
        System.out.print(OutputData.ERROR + " ");
    }
}
