package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class ProductFunction {
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void addProductList(String userInput) {
        String[] ProductInput = userInput.split(";");
        for (int i = 0; i < ProductInput.length; i++) {
            Product product = manufactureProduct(ProductInput[i]);
            productList.add(product);
        }
    }

    private Product manufactureProduct(String eachProduct) {
        String[] productInput = new String[0];
        int price = Integer.parseInt(productInput[1]);
        int amount = Integer.parseInt(productInput[2]);
        return new Product(productInput[0], price, amount);
    }

}
