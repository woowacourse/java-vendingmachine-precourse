package vendingmachine;

import java.util.LinkedHashMap;

public class Machine {
    private Message message = new Message();
    private CoinStock coinStock = new CoinStock();
    private User user = new User();
    private Products products = new Products();
    private Change change;

    public void run() {
        initProcess();
        orderProcess();
    }

    private void finishOrder(int remain) {
        message.printLackOfChanges();
        LinkedHashMap<Integer, Integer> changeCoinsMap = coinStock.getLastChanges(remain);
        message.printLastChanges(changeCoinsMap);
    }

    private void initProcess() {
        initHolding();
        initProduct();
        initAmount();
    }

    private void orderProcess() {
        while (true) {
            if (checkAmount()) {
                finishOrder(change.getAmount());
                break;
            }
            takeOrder();
        }
    }

    private void takeOrder() {
        message.printInputProductName();
        String productName = user.inputProductName();
        int price = products.calculateProduct(productName);
        change.decreaseAmount(price);
    }

    private boolean checkAmount() {
        int remain = change.getAmount();
        message.printChanges(remain);
        if (remain < products.getMaxPrice() || !products.isExistProduct()) {
            return false;
        }
        return true;
    }

    private void initHolding() {
        message.printInputHolding();
        int holding = user.inputHolding();
        coinStock.makeCoins(holding);
    }

    private void initProduct() {
        message.printInputProducts();
        String[] productsList = user.inputProducts();
        products.addProducts(productsList);
    }

    private void initAmount() {
        message.printInputAmount();
        int amount = user.inputAmount();
        change = new Change(amount);
    }
}
