package vendingmachine;

public class Adapter {
    private VendingMachine vendingMachine;

    public void run() {
        String value = View.putCoinIntoVendingMachine();
        vendingMachine = new VendingMachine(value);
        value = View.registerProduct();
        vendingMachine.createProduct(value);
        value = View.inputAmount();
        vendingMachine.createInputAmount(value);
        boolean canBuy = vendingMachine.checkUserBalance();
        while (canBuy) {
            value = View.buyProduct(vendingMachine.getUserBalance());
            vendingMachine.sell(value);
            canBuy = vendingMachine.checkUserBalance();
        }
        vendingMachine.getCoins();
    }
}
