package vendingmachine;

public class Application {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        CashManager cashManager = new CashManager();
        VendingMachine v = new VendingMachine(productManager, cashManager);

        v.run();
    }
}
