package vendingmachine;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller =
                new Controller(new VendingMachine(), new ValidatedInput());
        controller.requestMachineInfo();
        controller.startBuying();
    }
}
