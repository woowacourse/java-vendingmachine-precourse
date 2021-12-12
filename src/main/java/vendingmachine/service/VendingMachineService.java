package vendingmachine.service;

import vendingmachine.domain.*;

import java.util.List;

import static vendingmachine.utils.VerificationUtil.checkProduct;
import static vendingmachine.view.OutputView.printInputProductName;

public class VendingMachineService {

    public VendingMachine createVendingMachine(Change change, List<Product> productList, Money money) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.createChange(change);
        vendingMachine.inputProducts(productList);
        vendingMachine.inputMoney(money);

        return vendingMachine;
    }

    public void progressVendingMachine(VendingMachine vendingMachine) {
        while (vendingMachine.checkProgress()) {
            int restMoney = vendingMachine.getRestMoney();

            String productName = printInputProductName(restMoney);

            try {
                checkProduct(vendingMachine, productName);

                vendingMachine.extractProduct(productName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
