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

        String productInfo = Input.InputProductInfo();
        ProductController.saveProduct(product, productInfo);
        String inputMoney = Input.InputMoney();
        PurchaseController.purchase(vendingMachineMoney, product, Integer.parseInt(inputMoney));
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
