package vendingmachine;

import vendingmachine.controller.MachineController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
		MachineController machineController = new MachineController();
		machineController.start();
    }
}
