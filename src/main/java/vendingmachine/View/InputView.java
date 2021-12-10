package vendingmachine.View;

import vendingmachine.utils.Messages;

public class InputView {

    public void printInputMachineHaveMoney() {
        System.out.println(Messages.INPUT_MACHINE_HAVE_MONEY_MESSAGE.getInputMessage());
    }

    public void printInputProductInformation() {
        System.out.println(Messages.INPUT_PRODUCT_INFORMATION_MESSAGE.getInputMessage());
    }

    public void printInputPurchasingCost() {
        System.out.println(Messages.INPUT_USED_PURCHASING_MONEY_MESSAGE.getInputMessage());
    }

}
