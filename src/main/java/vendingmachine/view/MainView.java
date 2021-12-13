package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class MainView {
    public String askQuestion(InputData data) {
        System.out.println(data);
        return readLine();
    }

    public void printError() {
        System.out.print(OutputData.ERROR + " ");
    }
}
