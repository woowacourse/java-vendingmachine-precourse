package vendingmachine.view;

import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineController;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static vendingmachine.exception.PriceValidator.validateInt;


public class Input {
    public int inputMoney(){
        String input = readLine();
        validateInt(input);
        int money =Integer.parseInt(readLine());
        return money;
    }


}
