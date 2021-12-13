package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class MachineController {
    Coin[] coins = Coin.values();
    Machine machine;
    public int currentAmount = 0;

    MachineController(Machine machine) {
        this.machine = machine;
    }
    
}
