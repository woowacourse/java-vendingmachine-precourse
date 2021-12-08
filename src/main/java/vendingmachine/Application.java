package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.controller.ViewMappingKey;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachineController controller = new VendingMachineController();
        controller.view(ViewMappingKey.INPUT_FIRST_MONEY);
    }
}
