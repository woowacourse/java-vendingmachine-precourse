package vendingmachine;

import vendingmachine.controller.MachineCoinController;
import vendingmachine.controller.ProductController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MachineCoinController.initMachineCoin();
        ProductController.initProductList();
    }
}
