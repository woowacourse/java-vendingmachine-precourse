package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.controller.VendingMachineController;

public class Application {

    public static void main(String[] args) {
        VendingMachineController controller = new VendingMachineController();
        controller.init();
    }
}
