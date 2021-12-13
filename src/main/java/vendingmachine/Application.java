package vendingmachine;

import vendingmachine.controller.MachineController;

public class Application {
    public static void main(String[] args) {
        MachineController machineController = MachineController.getInstance();
        runVendingMachine(machineController);
    }

    private static void runVendingMachine(MachineController machineController) {
        machineController.initMachine();
        machineController.useMachine();
        machineController.endMachine();
    }
}
