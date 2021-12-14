package vendingmachine.customer;

import vendingmachine.exception.NotEnoughMoneyException;

public class CustomerController {

    private final CustomerService customerService;

    private CustomerController(){
        customerService = CustomerService.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final CustomerController instance = new CustomerController();
    }

    public static CustomerController getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void createCustomer(int initialAmount) {
        customerService.createCustomer(initialAmount);
    }

    public void purchaseItem(int purchaseAmount) {
        customerService.purchaseItem(purchaseAmount);
    }

    public void cancelPurchase(int purchaseAmount) {
        customerService.cancelPurchase(purchaseAmount);
    }

    public void hasPurchaseAmount(int purchaseAmount) {
        try {
            customerService.hasPurchaseAmount(purchaseAmount);
        }catch(NotEnoughMoneyException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Integer getRemainingAmount() {
        return customerService.getRemainingAmount();
    }
}