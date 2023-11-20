package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validators.InputValidator;

public class InputView implements Input{
    @Override
    public String readMoney() {
        return readInt();
    }

    @Override
    public String readProducts() {
        return readString();
    }

    @Override
    public String readInputAmount() {
        return readInt();
    }

    @Override
    public String readWanted() {
        return readString();
    }

    private String readInt(){
        String intInput = Console.readLine();
        return InputValidator.validateInt(intInput);
    }

    private String readString(){
        String stringInput = Console.readLine();
        return InputValidator.validateStringint(stringInput);
    }
}

