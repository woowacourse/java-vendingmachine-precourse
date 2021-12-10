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
        playInputVendingMachine();
        CoinController.makeCoin(vendingMachineMoney);
        Output.printVendingMachineCoin(vendingMachineMoney);

        playInputProduct();
        String inputMoney = Input.InputMoney();
        PurchaseController.purchase(vendingMachineMoney, product, Integer.parseInt(inputMoney));
    }

    private void playInputProduct() {
        while (true){
            String productInfo = Input.InputProductInfo();
            try {
                ValidationController.productValidation(productInfo);
                ProductController.saveProduct(product, productInfo);
                return;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void playInputVendingMachine(){
        int vendingMachineChange = 0;
        while (true) {
            String inputMoney = Input.InputVendingMachineChange();

            try {
                ValidationController.vendingMachineValidation(inputMoney);
                vendingMachineChange = Integer.parseInt(inputMoney);
                vendingMachineMoney = new VendingMachineMoney(vendingMachineChange);
                return;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
