package vendingmachine;

import controller.ProductsController;
import controller.UserPaymentController;
import controller.VendingMachineController;

public class Application {
    private static final VendingMachineController vendingMachineController = new VendingMachineController();
    private static final ProductsController productsController = new ProductsController();
    private static final UserPaymentController userPaymentController = new UserPaymentController();

    public static void main(String[] args) {
        init();
        purchaseProduct();
        printChange();
    }

    private static void init(){
        vendingMachineController.generateCoins();
        vendingMachineController.printGeneratedCoins();
        productsController.generateProductInfo();
        userPaymentController.generateUserBalance();
    }

    private static void purchaseProduct(){
        while (productsController.checkAvailableToPurchase()) {
            productsController.buyProduct();
        }
    }

    private static void printChange() {
        vendingMachineController.printChange();
    }
}
