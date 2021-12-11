package vendingmachine.Controller;

import vendingmachine.Service.InitHoldingCoinsService;
import vendingmachine.Service.InitInputAmountService;
import vendingmachine.Service.ProductService;
import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;

public class InitController {
    InitHoldingCoinsService holdingCoinsService = new InitHoldingCoinsService();
    ProductService productService = new ProductService();
    InitInputAmountService initInputAmountService = new InitInputAmountService();

    public void initVendingMachine() {
        initHoldingCoins();
        initProducts();
        initInputAmount();
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

    private void initProducts() {
        try {
            productService.setProducts(InputView.getProductInfo());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            initProducts();
        }
    }

    private void initInputAmount() {
        try {
            initInputAmountService.setInputAmount(InputView.getInputAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            initInputAmount();
        }
    }

}
