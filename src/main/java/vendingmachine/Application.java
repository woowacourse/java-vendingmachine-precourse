package vendingmachine;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Message message = new Message();
        User user = new User();
        Change change = new Change();
        Products products = new Products();

        message.printInputHolding();
        int holding = user.inputHolding();
        change.makeCoins(holding);
        message.printInputProducts();
        String[] productsList = user.inputProducts();
        products.addProducts(productsList);
    }
}
