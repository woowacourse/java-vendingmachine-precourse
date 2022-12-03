package vendingmachine;

import vendingmachine.controller.MachineController;

public class Application {
    public static void main(String[] args) {
        MachineController controller = new MachineController();
        controller.play();
    }
}
