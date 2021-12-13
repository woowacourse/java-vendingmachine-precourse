package vendingmachine;

import validator.ExceptionMessage;
import validator.ProductValidator;

import java.util.ArrayList;
import java.util.List;

public class ProductFunction {
    private static final String INPUT_DELIMITER = ";";

    private static final int PRODUCT_NAME_IDX = 0;
    private static final int PRICE_IDX = 1;
    private static final int AMOUNT_IDX = 2;

    private static final int NO_PRODUCT_PRICE = 0;

    private static List<Product> productList = new ArrayList<>();
    private static String productString;

    public List<Product> getProductList() {
        return productList;
    }

    public static String addProduct(String input) {
        String[] eachProductInput = input.split(INPUT_DELIMITER);
        for (int i = 0; i < eachProductInput.length; i++) {
            Product product = createProduct(eachProductInput[i]);
            isProductDuplicate(product);
            productList.add(product);
        }
        return productString;
    }

    public Product getProductByName(String productName){
        return productList.stream()
                .filter(product -> product.getProductName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.ERROR_PHRASE));
    }

    public void removeProduct(Product product){
        productList.remove(product);
    }

    public int getMinProductPrice() {
        return productList.stream()
                .mapToInt(product -> product.getPrice())
                .min()
                .orElse(NO_PRODUCT_PRICE);
    }

    public static Product createProduct(String eachProduct) {
        String[] productInput = ProductValidator.validateInput(eachProduct);
        int price = Integer.parseInt(productInput[PRICE_IDX]);
        int amount = Integer.parseInt(productInput[AMOUNT_IDX]);
        return new Product(productInput[PRODUCT_NAME_IDX], price, amount);
    }

    private static void isProductDuplicate(Product product) {
        if(productList.contains(product)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PHRASE);
        }
    }
}