package vendingmachine.service;

import vendingmachine.domain.Product;

import java.util.ArrayList;
import java.util.List;

import static vendingmachine.utils.VerificationUtil.validateProductInput;
import static vendingmachine.view.OutputView.printInputVendingMachineProduct;

public class ProductService {

    public List<Product> createProducts() {
        List<Product> productList = createProductListByInput();

        return productList;
    }

    private List<Product> createProductListByInput() {
        while (true) {
            try {
                String input = printInputVendingMachineProduct();

                validateProductInput(input);

                return createProductList(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Product> createProductList(String input) {
        List<Product> productList = new ArrayList<>();

        String[] splitString = input.split(";");

        for (String s : splitString) {

            String[] resultStrings = splitProductInfo(s);

            Product product = createProduct(resultStrings);

            productList.add(product);
        }

        return productList;
    }

    private static String[] splitProductInfo(String splitString) {
        String resultString = splitString.substring(1, splitString.length() -1);

        String[] resultStrings = resultString.split(",");

        return resultStrings;
    }

    private static Product createProduct(String[] strings) {
        String productName = strings[0];

        int price = Integer.parseInt(strings[1]);

        int quantity = Integer.parseInt(strings[2]);

        Product product = new Product(productName, price, quantity);

        return product;
    }
}
