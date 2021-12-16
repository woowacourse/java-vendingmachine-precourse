package vendingmachine.view;

import vendingmachine.domain.Product;
import vendingmachine.domain.ProductList;

import java.util.HashMap;

public class ProductOutputView {
    public  void  printProductList(ProductList productList){
        for(String name  : productList.getProductList().keySet()){
            System.out.println(productList.getProductList().get(name).toString());
        }
    }
}
