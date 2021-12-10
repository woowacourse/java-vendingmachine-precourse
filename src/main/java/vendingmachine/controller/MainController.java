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

    public void playGame() {
        playInputVendingMachine();
        CoinController.makeCoin(vendingMachineMoney);
        Output.printVendingMachineCoin(vendingMachineMoney);

        playInputProduct();
        playInputMoney();
    }

    private void playInputVendingMachine() {
        int vendingMachineChange = 0;
        while (true) {
            String inputMoney = Input.InputVendingMachineChange();

            try {
                ValidationController.vendingMachineValidation(inputMoney);
                vendingMachineChange = Integer.parseInt(inputMoney);
                vendingMachineMoney = new VendingMachineMoney(vendingMachineChange);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void playInputProduct() {
        while (true) {
            String productInfo = Input.InputProductInfo();
            try {
                ValidationController.productValidation(productInfo);
                ValidationController.duplicateValidation(productInfo);
                ValidationController.productAmountValidation(productInfo);
                ValidationController.quantityValidation(productInfo);
                ProductController.saveProduct(product, productInfo);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void playInputMoney() {
        while (true) {
            String inputMoney = Input.InputMoney();
            try {
                ValidationController.vendingMachineValidation(inputMoney);
                PurchaseController.purchase(vendingMachineMoney, product, Integer.parseInt(inputMoney));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
