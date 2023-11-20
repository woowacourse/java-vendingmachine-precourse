package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validators.InputValidator;

public class InputView implements Input{

    private static final InputView inputView = new InputView();

    public static Input getInstance() {
        return new ProxyInputView(inputView);
    }

    @Override
    public String readHoldMoney() {
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

