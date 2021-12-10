package vendingmachine.Controller;

import vendingmachine.Service.InitHoldingCoinsService;
import vendingmachine.Service.ValidatorService;
import vendingmachine.View.CoinOutputView;
import vendingmachine.View.ErrorOutputView;
import vendingmachine.View.InitView;

public class InitController {
    ValidatorService validatorService = new ValidatorService();
    InitHoldingCoinsService holdingCoinsService = new InitHoldingCoinsService();

    public void initVendingMachine() {
        initHoldingCoins();
    }

    private void initHoldingCoins() {
        try {
            String holdingAmount = InitView.getHoldingAmount();
            validatorService.isValidHoldingAmount(holdingAmount);
            holdingCoinsService.setHoldingCoins(Integer.parseInt(holdingAmount));
            CoinOutputView.printHoldingCoins();
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printError(e.getMessage());
            initHoldingCoins();
        }
    }

}
