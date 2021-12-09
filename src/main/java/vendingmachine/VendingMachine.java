package vendingmachine;

import vendingmachine.coin.CoinController;
import vendingmachine.machine.MachineController;
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

    }
}
