package vendingmachine.customer;

import vendingmachine.exception.NotEnoughMoneyException;
import vendingmachine.utils.message.OutputMessage;
import vendingmachine.utils.validator.InputDataValidator;
import vendingmachine.utils.validator.MoneyDataValidator;

public class CustomerController {

    private final CustomerService customerService;
    private final InputDataValidator inputDataValidator;

    private CustomerController(){
        customerService = CustomerService.getInstance();
        inputDataValidator = MoneyDataValidator.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final CustomerController instance = new CustomerController();
    }

    public static CustomerController getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void createCustomer(String initialAmount) {
        inputDataValidator.validateData(initialAmount);
        customerService.createCustomer(Integer.parseInt(initialAmount));
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

    public void printBalance() {
        System.out.println(OutputMessage.CUSTOMER_BALANCE_PRINT_FORMAT
                .replace("balance", String.valueOf(getBalance())));
    }

    public Integer getBalance() {
        return customerService.getBalance();
    }
}