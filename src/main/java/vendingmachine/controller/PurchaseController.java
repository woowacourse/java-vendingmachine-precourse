package vendingmachine.controller;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachineMoney;
import vendingmachine.view.Input;

public class PurchaseController {
    public static void purchase(VendingMachineMoney vendingMachineMoney, Product product, int inputMoney){
        product.setMinPrice();
        product.setSumCount();

        while (inputMoney >= product.getMinPrice() && product.getSumCount() != 0){
            String productName = Input.InputPurchase(inputMoney);
            inputMoney -= product.getPrice(productName);
            product.replaceProductCount(productName, product.getCount(productName)-1);

            product.setSumCount();
        }
    }
}
