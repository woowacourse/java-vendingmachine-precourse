package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) {
        Message message = new Message();
        User user = new User();
        CoinStock coinStock = new CoinStock();
        Products products = new Products();

        message.printInputHolding();
        int holding = user.inputHolding();
        coinStock.makeCoins(holding);

        message.printInputProducts();
        String[] productsList = user.inputProducts();
        products.addProducts(productsList);

        message.printInputAmount();
        int amount = user.inputAmount();
        Change change = new Change(amount);

        while (true) {
            int remain = change.getAmount();
            message.printChanges(remain);
            if (remain < products.getMaxPrice() || !products.isExistProduct()) {
                message.printLackOfChanges();
                LinkedHashMap<Integer, Integer> changeCoinsMap = coinStock.getLastChanges(remain);
                message.printLastChanges(changeCoinsMap);
                break;
            }
            message.printInputProductName();
            String productName = user.inputProductName();
            int price = products.calculateProduct(productName);
            change.decreaseAmount(price);
        }

    }
}
