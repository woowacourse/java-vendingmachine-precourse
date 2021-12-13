package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getMoney() {
        return Console.readLine();
    }

    public String getProduct() {
        return Console.readLine();
    }

    public String getOrder() {
        return Console.readLine();
    }

}
