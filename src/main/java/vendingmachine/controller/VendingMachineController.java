package vendingmachine.controller;

import vendingmachine.model.Product;
import vendingmachine.model.Products;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;

import java.util.List;

public class VendingMachineController {
    private final InputView input;

    public VendingMachineController() {
        this.input = new InputView();
    }

    public void run() {
        VendingMachine vendingMachine = createVendingMachine();
        System.out.println(vendingMachine.getAllChangesString());
        int payment = inputMoney(vendingMachine);

        while (!vendingMachine.isExit()) {
            String purchase = input.inputPurchase(payment);
            int buy = vendingMachine.buyProduct(purchase);
            payment -= buy;
        }

        System.out.println(vendingMachine.getPayChangeString());
    }

    private VendingMachine createVendingMachine() {
        int change = input.inputVendingmachineChange();
        List<Product> products = input.inputProductList();
        return new VendingMachine(change, new Products(products));
    }

    private int inputMoney(VendingMachine vendingMachine) {
        int payment = input.inputUserPay();
        vendingMachine.pay(payment);
        return payment;
    }

}
