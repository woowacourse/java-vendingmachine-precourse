package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MachineController {
    Coin[] coins = Coin.values();
    Machine machine;

    MachineController(Machine machine) {
        this.machine = machine;
    }

    
}
