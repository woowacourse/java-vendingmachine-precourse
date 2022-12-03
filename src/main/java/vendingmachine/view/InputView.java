package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.exception.VendingMachineException;

public class InputView {
    VendingMachineException vendingMachineException = new VendingMachineException();

    public String inputVendingMoney(){
        System.out.println(GameMessage.INPUT_VENDINGMACHINE_MONEY);
        String vendingMoney = Console.readLine();
        vendingMachineException.validInputMoney(vendingMoney);
        return vendingMoney;
    }

}
