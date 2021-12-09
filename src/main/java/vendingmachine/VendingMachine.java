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
            if (!machineController.buyProduct(product.getPrice())) {
                throw new IllegalArgumentException(ValidatorMessage.ERROR_MESSAGE
                        + ValidatorMessage.NOT_ENOUGH_AMOUNT);
            }
            productsController.buyProduct(product);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyProduct();
        }
    }
}
