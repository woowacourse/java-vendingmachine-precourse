package vendingmachine.repository;

import vendingmachine.model.Product;
import vendingmachine.model.Products;

public class ProductsRepository {
    private static Products products;

    public static void createProducts(String inputProducts) {
        products = new Products(inputProducts);
    }

    public static Products getProducts() {
        return products;
    }

    public static int getCheapest() {
        return products.getCheapest();
    }

    public static boolean hasAnyProducts() {
        return products.hasAnyProduct();
    }

    public static int existProductToBuy(int amount) {
        return products.existProductToBuy(amount);
    }

    public static boolean hasProduct(String productName) {
        return products.existProductName(productName);
    }

    public static boolean checkProductQuantity(String productName) {
        return products.isQuantityEnough(productName);
    }

    public static int getProductPrice(String productName) {
        return products.getPrice(productName);
    }

    public static void popProduct(String productName) {
        products.reduceQuantity(productName);
    }

    public static Product findProductByName(String productName) {
        return products.findByName(productName);
    }
}
