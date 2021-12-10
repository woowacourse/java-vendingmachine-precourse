package vendingmachine.controller;

import vendingmachine.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductController {
    public static void saveProduct(Product product, String productInfo){
        String[] productList = productInfo.split(";");
        removeBrackets(productList);

        for (int i = 0; i< productList.length; i++) {
            String[] productData = productList[i].split(",");
            product.putProductPrice(productData[0], Integer.parseInt(productData[1]));
            product.putProductCount(productData[0], Integer.parseInt(productData[2]));
        }
    }

    private static void removeBrackets(String[] productList) {
        for (int i = 0; i< productList.length; i++){
            productList[i] = productList[i].substring(1, productList[i].length()-1);
        }
    }
}
