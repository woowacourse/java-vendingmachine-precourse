package vendingmachine.model;

import java.util.List;
import vendingmachine.util.Index;
import vendingmachine.util.Util;

public class Product {
    private final String productName;
    private final int productPrice;
    private int productQuantity;

    private Product(List<String> productInfo) {
        this.productName = productInfo.get(Index.PRODUCT_NAME_INDEX.getIndex());
        this.productPrice = Integer.parseInt(productInfo.get(Index.PRODUCT_PRICE_INDEX.getIndex()));
        this.productQuantity = Integer.parseInt(productInfo.get(Index.PRODUCT_QUANTITY_INDEX.getIndex()));
    }

    public static Product from(String productInfo) {
        return new Product(Util.formatProductInfo(productInfo));
    }

    public boolean isSame(String productName) {
        return this.productName.equals(productName);
    }

    public boolean hasStock() {
        return this.productQuantity > 0;
    }

    public void buy() {
        this.productQuantity--;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public boolean isAffordable(int budget) {
        return this.productPrice <= budget;
    }

}
