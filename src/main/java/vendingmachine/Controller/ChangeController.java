package vendingmachine.Controller;

import vendingmachine.Service.ChangeService;
import vendingmachine.View.OutputView;

public class ChangeController {
    ChangeService changeService = new ChangeService();

    public void returnChange() {
        changeService.calculateChange();
        OutputView.printChange();
    }
}
