package vendingmachine;

public class Application {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Customer customer = new Customer();
        customer.purchaseProduct(vendingMachine);
        vendingMachine.returnChanges(customer);
    }
}
