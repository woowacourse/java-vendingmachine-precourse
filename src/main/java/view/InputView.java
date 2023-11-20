package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Parser;

public class InputView {

    public static int readVendingMachineMoney() {
        String amount = Console.readLine();
        return Parser.convertToInt(amount);
    }
}
