package vendingmachine.Controller;

import vendingmachine.Service.InitHoldingCoinsService;
import vendingmachine.Service.ProductService;
import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;

public class InitController {
    InitHoldingCoinsService holdingCoinsService = new InitHoldingCoinsService();
    ProductService productService = new ProductService();

    public void initVendingMachine() {
        initHoldingCoins();
    }

    private void initHoldingCoins() {
        try {
            holdingCoinsService.setHoldingCoins(InputView.getHoldingAmount());
            OutputView.printHoldingCoins();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            initHoldingCoins();
        }
    }

}
