package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import controller.VendingMachineController;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.start();
    }
}
