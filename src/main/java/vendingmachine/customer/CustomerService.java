package vendingmachine.customer;

public class CustomerService {

    private Customer customer;

    private static class InnerInstanceClazz {
        private static final CustomerService instance = new CustomerService();
    }

    public static CustomerService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void createCustomer(int initialAmount) {
        customer = Customer.fromInputAmount(initialAmount);
    }

    public void purchaseItem(int purchaseAmount) {
        customer.reduceBalance(purchaseAmount);
    }

    public void cancelPurchase(int purchaseAmount) {
        customer.addBalance(purchaseAmount);
    }

    public void hasPurchaseAmount(int purchaseAmount) {
        customer.hasPurchaseAmount(purchaseAmount);
    }

    public Integer getBalance() {
        return customer.getBalance();
    }
}