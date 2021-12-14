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

    public int getMoney() {
        return moneyOfMachine;
    }

    public void setSpentMoney(int spentMoney) {
        this.spentMoney=spentMoney;
    }

    public int getSpentMoney() {
        return spentMoney;
    }

    public boolean createProducts(String[] products) {
        for (int i=0; i<products.length; i++) {
            String temp = products[i].substring(1,products[i].length()-1);
            String[] result = temp.split(",");
            if (!verifyNumber(result[1])) {
                productList.clear();
                return false;
            }
            if (!verifyNumber(result[2])) {
                productList.clear();
                return false;
            }
            Product product = new Product(result);

            productList.add(product);
        }
        return true;
    }

    public boolean verifyNumber(String str) {
        if (!View.isStringDouble(str)) {
            productList.clear();
            return false;
        }
        if (Integer.parseInt(str) <= 0) {
            productList.clear();
            return false;
        }
        return true;
    }



    public List<Product> getProductList() {
        return productList;
    }

    public void buyProduct(String menu) {
        for (int i = 0; i < productList.size(); i++) {
            if (menu.equals(productList.get(i).getName())) {
                setSpentMoney(spentMoney - productList.get(i).getPrice());
                productList.get(i).changeQuantity(-1);
            }
        }
    }

    public int getMinPrice() {
        int minPrice = 99999;
        for (int i=0; i<productList.size(); i++) {
            if (productList.get(i).getPrice() < minPrice) {
                minPrice = productList.get(i).getPrice();
            }
        }
        return minPrice;
    }
}
