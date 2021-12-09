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
    }


}
