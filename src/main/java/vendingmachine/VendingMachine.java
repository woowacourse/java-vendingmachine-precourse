package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private int moneyOfMachine;
    private int spentMoney;
    private List<Product> productList = new ArrayList<Product>();

    public void setMoney(int moneyOfMachine) {
        this.moneyOfMachine=moneyOfMachine;
    }

    public void setSpentMoney(int spentMoney) {
        this.spentMoney=spentMoney;
    }

    public int getSpentMoney() {
        return spentMoney;
    }

    public void createProducts(String[] products) {
        for (int i=0; i<products.length; i++) {
            String temp = products[i].substring(1,products[i].length()-1);
            String[] result = temp.split(",");
            Product product = new Product(result);
            productList.add(product);
        }
    }

    public List<Product> getProductList() {
        return productList;
    }
}
