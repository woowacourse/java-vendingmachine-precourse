package vendingmachine;

import vendingmachine.management.ManagementController;
import vendingmachine.operation.OperationController;
import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        
        ManagementController.runManagement(inputView);
        OperationController.runOperation(inputView);
    }
}
