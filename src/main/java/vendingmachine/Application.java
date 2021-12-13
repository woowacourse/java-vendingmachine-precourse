package vendingmachine;

import vendingmachine.domain.Changes;
import vendingmachine.service.RequestService;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Changes changes = RequestService.requestChanges();
        OutputView.vendingMachineChanges(changes);
    }
}
