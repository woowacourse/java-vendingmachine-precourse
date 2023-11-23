package vendingmachine.view;

import static vendingmachine.view.constants.MachineMessage.INPUT_MACHINE_MONEY;
import static vendingmachine.view.constants.MachineMessage.INPUT_MACHINE_PRODUCT;
import static vendingmachine.view.constants.UserMessage.INPUT_USER_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.constants.UserMessage;

public class InputView {
    public String inputMachineMoney() {
        System.out.println(INPUT_MACHINE_MONEY.getMessage());
        return Console.readLine();
    }

    public String inputMachineProduct(){
        System.out.println(INPUT_MACHINE_PRODUCT.getMessage());
        return Console.readLine();
    }

    public String inputUserAmount(){
        System.out.println(INPUT_USER_AMOUNT.getMessage());
        return Console.readLine();
    }
}
