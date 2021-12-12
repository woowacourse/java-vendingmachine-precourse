package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MachineController {
    Coin[] coins = Coin.values();
    Machine machine;
    public int currentAmount = 0;

    MachineController(Machine machine) {
        this.machine = machine;
    }

    public int pickRandomCoin() {
        int random = Randoms.pickNumberInList(new ArrayList<Integer>(Arrays.asList(500,100,50,10)));

        return random;
    }
}
