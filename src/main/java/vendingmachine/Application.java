package vendingmachine;

import java.util.ArrayList;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.StringUtil;
import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {
        new VendingMachine().start();
    }
}
