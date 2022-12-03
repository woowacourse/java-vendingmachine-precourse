package vendingmachine.Util;

import static vendingmachine.Constant.Message.*;

public class Print {

    public void inputChanges() {
        System.out.println(INITIALIZE_CHANGES.getMessage());
    }

    public void inputProductInfo() {
        System.out.println(INITIALIZE_PRODUCTS.getMessage());
    }

    public void inputPurchaseMoney() {
        System.out.println(PURCHASE_MONEY.getMessage());
    }

    public void inputProductToBuy() {
        System.out.println(PURCHASE_PRODUCT.getMessage());
    }

}
