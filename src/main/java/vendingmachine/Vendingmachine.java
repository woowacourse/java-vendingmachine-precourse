package vendingmachine;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Vendingmachine {
   // public static String status = "operating";
    private List<String> products_list;


    InputView inputview=new InputView();

    public Vendingmachine() {
        //own_coins= Collections.emptyList();
        // vending_products= inputview.readproduct_list(inputview.read());
    }

    public List<Products> set_vending_products(List<String> products_format) {
        List<Products> products=new ArrayList<>();
        String[] list;
        for (String option : products_format) {
            list = option.split(",");

            products.add(new Products(list[0], list[1], list[2]));
        }
        return products;
    }

}
