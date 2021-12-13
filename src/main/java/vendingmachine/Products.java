package vendingmachine;

import java.util.ArrayList;

public class Products {
    private static ArrayList<Product> productsList = new ArrayList<>();

    public void addProducts(String[] products) {
        for (String product : products) {
            String removedBrackets = product.substring(1, product.length() - 1);
            String[] divided = removedBrackets.split(",");
            String name = divided[0];
            int price = Integer.parseInt(divided[1]);
            int number = Integer.parseInt(divided[2]);
            productsList.add(new Product(name, price, number));
        }
    }

    public int getMaxPrice() {
        int result = 0;
        for (Product p : productsList) {
            result = Math.max(result, p.getPrice());
        }
        return result;
    }

    public boolean isSingleProductName(String input) throws IllegalArgumentException {
        int count = 0;
        for (Product p : productsList) {
            if (p.isInclude(input)) {
                count += 1;
            }
        }
        if (count == 1) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
