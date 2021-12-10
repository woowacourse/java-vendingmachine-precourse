package vendingmachine.controller;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachineMoney;
import vendingmachine.view.Input;

public class PurchaseController {
    public static void purchase(VendingMachineMoney vendingMachineMoney, Product product, int inputMoney){
        String productName = Input.InputPurchase(inputMoney);
        product.setMinPrice();
        product.setSumCount();
        System.out.println(product.getMinPrice());
        System.out.println(product.getSumCount());
    }
}
