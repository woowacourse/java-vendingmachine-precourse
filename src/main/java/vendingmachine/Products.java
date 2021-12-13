package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Products {
    private static final List<Product> products = new ArrayList<>();

    public Products(String productInfo) {
        makeProducts(productInfo);
    }

    private void makeProducts(String productInfo) {
        String[] productsString = productInfo.split(";");
        for (String productString : productsString) {
            List<String> productResult = Arrays.asList(productString.replace("[", "").replace("]", "").split(","));
            Product product = new Product(productResult.get(0), Integer.parseInt(productResult.get(1)), Integer.parseInt(productResult.get(2)));
            products.add(product);
        }
    }
}
