package vendingmachine;

import java.util.ArrayList;
import static vendingmachine.Validation.*;

public class Product {
    private final String name;
    private final int price;
    private int amount;

    public Product(String name, int price, int amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    } // 생성자 종료

    public void sold(){
        this.amount--;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }


    public static ArrayList<Product> createProductList(ArrayList<String> productStringList){
        ArrayList<Product> productList = new ArrayList<>();
        for(int i = 0; i < productStringList.size()-2; i+=3){
            productList.add(new Product(productStringList.get(i+PRODUCT_NAME), Integer.parseInt(productStringList.get(i+PRODUCT_PRICE)), Integer.parseInt(productStringList.get(i+PRODUCT_AMOUNT))));
        }
        return productList;
    }

}
