package vendingmachine.view;

import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineController;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Input {
    public int inputMoney(){
        int money =Integer.valueOf(readLine()); //나중에 exceptio추가

        return money;
    }

}
