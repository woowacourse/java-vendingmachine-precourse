package vendingmachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ProductManager pm = new ProductManager();
        CashManager cm = new CashManager();
        VendingMachine v = new VendingMachine(pm, cm);

        v.run();
    }
}
