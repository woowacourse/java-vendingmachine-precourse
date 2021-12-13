package vendingmachine.service;

import vendingmachine.domain.Product;

import java.util.ArrayList;
import java.util.List;

import static vendingmachine.utils.VerificationUtil.checkProductPrice;
import static vendingmachine.utils.VerificationUtil.validateProductInput;
import static vendingmachine.view.OutputView.printInputVendingMachineProduct;

public class ProductService {

    private static final String SEPARATOR = ";";
    private static final String DELIMITER = ",";
    private static final int PRODUCTNAMEINDEX = 0;
    private static final int PRICEINDEX = 1;
    private static final int QUANTITYINDEX = 2;

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

        String[] splitString = input.split(SEPARATOR);

        for (String s : splitString) {

            String[] resultStrings = splitProductInfo(s);

            Product product = createProduct(resultStrings);

            productList.add(product);
        }

        return productList;
    }

    private static String[] splitProductInfo(String splitString) {
        String resultString = splitString.substring(1, splitString.length() -1);

        String[] resultStrings = resultString.split(DELIMITER);

        return resultStrings;
    }

    private static Product createProduct(String[] strings) {
        String productName = strings[PRODUCTNAMEINDEX];

        int price = Integer.parseInt(strings[PRICEINDEX]);

        checkProductPrice(price);

        int quantity = Integer.parseInt(strings[QUANTITYINDEX]);

        Product product = new Product(productName, price, quantity);

        return product;
    }
}
