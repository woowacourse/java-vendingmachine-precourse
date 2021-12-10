package vendingmachine.View;

import vendingmachine.utils.InputMessages;
import vendingmachine.utils.Symbol;

public class InputView {

    public void printInputMachineHaveMoney() {
        System.out.println(InputMessages.INPUT_MACHINE_HAVE_MONEY_MESSAGE.getInputMessage());
    }

    public void printInputProductInformation() {
        System.out.println(InputMessages.INPUT_PRODUCT_INFORMATION_MESSAGE.getInputMessage());
    }

}
