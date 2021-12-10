package vendingmachine;

import vendingmachine.Controller.VendingMachineController;

public class Application {
    private static final String PRODUCT_REGULAR_EXPRESSION = "^\\[[가-힣]+,[0-9]+,[0-9]+\\];$";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.run();

    }
}
