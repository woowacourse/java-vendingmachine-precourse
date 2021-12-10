package vendingmachine.controller;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachineMoney;
import vendingmachine.view.Input;

public class PurchaseController {
    public static void purchase(VendingMachineMoney vendingMachineMoney, Product product, int inputMoney){
        product.setMinPrice();
        product.setSumCount();

        while (checkChange(inputMoney, product.getMinPrice()) && checkCount(product.getSumCount())){
            String productName = Input.InputPurchase(inputMoney);
            inputMoney -= product.getPrice(productName);
            product.replaceProductCount(productName, product.getCount(productName)-1);

            product.setSumCount();
        }
    }
        
    private static boolean checkChange(int remainMoney, int minPrice){
        if (remainMoney >= minPrice){
            return true;
        }
        return false;
    }

    private static boolean checkCount(int count){
        if (count != 0){
            return true;
        }
        return false;
    }
}
