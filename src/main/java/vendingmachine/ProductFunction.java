package vendingmachine;

import validator.ExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductFunction {
    private static final String INPUT_DELIMITER = ";";

    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    private static List<Product> productList = new ArrayList<>();
    private static String productString;

    public List<Product> getProductList() {
        return productList;
    }

//    public static String addProduct(String input) {
//        String[] eachProductInput = input.split(INPUT_DELIMITER);
//        for (int i = 0; i < eachProductInput.length; i++) {
//            Product product = createProduct(eachProductInput[i]);
//            isProductDuplicate(product);
//            productList.add(product);
//        }
//        return productString;
//    }

    public static Product getProductByName(String productName){
        return productList.stream()
                .filter(product -> product.getProductName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.ERROR_PHRASE));
    }

    public static List<Product> createProduct(String eachProduct) {
        String[] tempProductList = eachProduct.split(";");
        List<Product> productInformationList = new ArrayList<>();

        for (String s : tempProductList) {
            List<String> information = Arrays.asList(s.split(","));
            String productName = information.get(0);
            int price = Integer.parseInt(information.get(1));
            int count = Integer.parseInt(information.get(2));
            productInformationList.add(new Product(productName, price, count));
        }

        return productInformationList;
    }

    private static void isProductDuplicate(Product product) {
        if(productList.contains(product)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PHRASE);
        }
    }


}