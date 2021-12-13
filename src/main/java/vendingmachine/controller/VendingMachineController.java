package vendingmachine.controller;

public class VendingMachineController {
    CoinController coinController = new CoinController();
    ProductController productController = new ProductController();

    public void run(){
        coinController.generate();
        productController.generate();

    }
}
