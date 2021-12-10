package vendingmachine.controller;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachineMoney;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class MainController {
    VendingMachineMoney vendingMachineMoney;
    Product product;

    public MainController() {
        product = new Product();
    }

    public void playGame(){
//        int vendingMachineChange = Input.InputVendingMachineChange();
//        vendingMachineMoney = new VendingMachineMoney(vendingMachineChange);
//        CoinController.makeCoin(vendingMachineMoney);
//        Output.printVendingMachineCoin(vendingMachineMoney);

        String productInfo = Input.InputProductInfo();
        ProductController.saveProduct(product, productInfo);
    }
}
