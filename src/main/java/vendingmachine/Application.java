package vendingmachine;

import vendingmachine.controller.MachineController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MachineController machine = new MachineController();
        machine.run();
    }
}
