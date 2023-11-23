package vendingmachine.view;

import static vendingmachine.view.constants.MachineMessage.INPUT_MACHINE_MONEY;
import static vendingmachine.view.constants.MachineMessage.INPUT_MACHINE_PRODUCT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputMachineMoney() {
        System.out.println(INPUT_MACHINE_MONEY.getMessage());
        return Console.readLine();
    }

    public String inputMachineProduct(){
        System.out.println(INPUT_MACHINE_PRODUCT.getMessage());
        return Console.readLine();
    }
}
