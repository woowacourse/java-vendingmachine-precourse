package vendingmachine;

import vendingmachine.coin.CoinController;
import vendingmachine.machine.MachineController;
import vendingmachine.products.Product;
import vendingmachine.products.ProductsController;

public class VendingMachine {
    private final CoinController coinController;
    private final ProductsController productsController;
    private final MachineController machineController;

    public VendingMachine() {
        coinController = new CoinController();
        coinController.initCoinsPrint();
        productsController = new ProductsController();
        productsController.initProducts();
        machineController = new MachineController();
    }

    public void run() {
        int nowAmount = machineController.nowInputAmount();
        while (productsController.canBuyAnyProduct(nowAmount)) {
            machineController.nowInputAmountInfo();
            buyProduct();
            nowAmount = machineController.nowInputAmount();
        }
        coinController.repayCoinsPrint(nowAmount);
    }

    public void buyProduct() {
        try {
            String buyProductName = machineController.buyWhichProduct();
            Product product = productsController.findProduct(buyProductName);
            machineController.buyProduct(product.getPrice());
            productsController.buyProduct(product);
        } catch (IllegalArgumentException e) {
            ValidatorMessage.printError(e.getMessage());
            buyProduct();
        }
    }
}
