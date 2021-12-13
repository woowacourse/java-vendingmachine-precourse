package vendingmachine;

import vendingmachine.controller.RequestController;
import vendingmachine.domain.Changes;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Changes changes = RequestController.requestChanges();
        OutputView.vendingMachineChanges(changes);
    }
}
