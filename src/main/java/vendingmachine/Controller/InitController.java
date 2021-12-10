package vendingmachine.Controller;

import vendingmachine.Service.InitHoldingCoinsService;
import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;

public class InitController {
    InitHoldingCoinsService holdingCoinsService = new InitHoldingCoinsService();

    public void initVendingMachine() {
        initHoldingCoins();
    }

    private void initHoldingCoins() {
        try {
            String holdingAmount = InputView.getHoldingAmount();
            holdingCoinsService.isValidHoldingAmount(holdingAmount);
            holdingCoinsService.setHoldingCoins(Integer.parseInt(holdingAmount));
            OutputView.printHoldingCoins();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            initHoldingCoins();
        }
    }

}
