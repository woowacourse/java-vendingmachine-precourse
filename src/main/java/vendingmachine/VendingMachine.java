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
        while(productsController.canBuyAnyProduct(machineController.nowInputAmount())){
            machineController.nowInputAmountInfo();
            if (!buyProduct()) {
                // 잔액 반환
                break;
            }
        }
    }

    public boolean buyProduct() {
        String buyProductName = machineController.buyWhichProduct();
        Product product = productsController.findProduct(buyProductName);
        if (!machineController.buyProduct(product.getPrice())) {
            return false;
        }
        productsController.buyProduct(product);
        return true;
    }
}
