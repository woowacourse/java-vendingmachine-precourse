package vendingmachine;

import controller.ProductsController;
import controller.UserPaymentController;
import controller.VendingMachineController;
import view.InputView;
import view.OutputView;

public class Application {
    private static final VendingMachineController vendingMachineController = new VendingMachineController();
    private static final ProductsController productsController = new ProductsController();
    private static final UserPaymentController userPaymentController = new UserPaymentController();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        init(inputView, outputView);
        purchaseProduct(inputView);
        printChange();
    }

    private static void init(InputView inputView, OutputView outputView){
        vendingMachineController.generateCoins(inputView, outputView);
        vendingMachineController.printGeneratedCoins();
        productsController.initProductInfo(inputView, outputView);
        userPaymentController.generateUserBalance(inputView,outputView);
    }

    private static void purchaseProduct(InputView inputView){
        while (productsController.checkAvailableToPurchase()) {
            productsController.buyProduct(inputView);
        }
    }

    private static void printChange() {
        vendingMachineController.printChange();
    }
}
