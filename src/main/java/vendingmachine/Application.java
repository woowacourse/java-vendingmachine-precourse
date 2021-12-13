package vendingmachine;

import vendingmachine.domain.VendingMachine;

public class Application {
    public static void main(String[] args) {
        Controller controller =
                new Controller(new VendingMachine(), new ValidatedInput());
        controller.requestMachineInfo();
        controller.startBuying();
    }
}
