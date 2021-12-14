package vendingmachine.controller;

public class OutPutVendingMachineController {

    private OutPutVendingMachineController() {}

    private static class LazyHolder {
        public static final OutPutVendingMachineController INSTANCE = new OutPutVendingMachineController();
    }

    public static OutPutVendingMachineController getInstance() {
        return OutPutVendingMachineController.LazyHolder.INSTANCE;
    }

    public void printConsoleMessage(String message) {
        System.out.println(message);
    }
}
