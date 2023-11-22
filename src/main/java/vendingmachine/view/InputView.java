package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.view.validate.InputValidator.checkNumericInput;

public class InputView {
    public static String readLine(){
        return Console.readLine();
    }

    public static int readTotalMoney(){
        String totalMoney = readLine();
        checkNumericInput(totalMoney);
        return Integer.parseInt(totalMoney);
    }
}
