package vendingmachine;

import vendingmachine.controller.ChangeController;
import vendingmachine.controller.ProductController;
import vendingmachine.domain.Change;

public class Controller {
    private ChangeController changeController;
    private ProductController productController;

    public Controller() {
        changeController = new ChangeController();
        productController = new ProductController();
    }

    public void run() {
        changeController.insertChange();
        changeController.changeToCoin();
        productController.inputProduct();
    }
}
