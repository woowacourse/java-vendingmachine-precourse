package vendingmachine.service;

import java.util.ArrayList;

import vendingmachine.repository.Product;
import vendingmachine.repository.Products;
import vendingmachine.view.InputView;

public class ProductService {

    ProductValidator productValidator = new ProductValidator();

    public Products generate() {
        while (true) {
            try {
                return new Products(replaceString(InputView.getProduct()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public ArrayList<Product> replaceString(String input) {
        ArrayList<Product> products = new ArrayList<>();

        for (String product : splitInput(input)) {
            String[] item = product.split(",");
            productValidator.isValid(item);
            products.add(new Product(item[0],
                Integer.parseInt(item[1]),
                Integer.parseInt(item[2])));
        }
        return products;
}

    public String[] splitInput(String input) {
        return input.replaceAll("\\[", "")
            .replaceAll("]", "")
            .split(";");
    }
}
