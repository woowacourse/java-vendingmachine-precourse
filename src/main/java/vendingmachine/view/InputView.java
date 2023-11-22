package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getProductName() {
        return readLine();
    }

    private String readLine() {
        return Console.readLine().trim();
    }

}
