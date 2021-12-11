package vendingmachine.View;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Messages;

public class InputView {

    public String inputMoney(final String message) {
        System.out.println(message);
        return inputValue();
    }

    public String inputProducts() {
        System.out.println(Messages.INPUT_PRODUCT_INFORMATION_MESSAGE.getInputMessage());
        return inputValue();
    }

    public String inputValue() {
        return Console.readLine();
    }

    public String inputPurchasingProductName(){
        System.out.println(Messages.INPUT_PURCHASING_PRODUCT_NAME.getInputMessage());
        return inputValue();
    }

}
