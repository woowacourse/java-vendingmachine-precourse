package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachine {
    private static final Change change = new Change();
    private static final Validator validator = new Validator();
    private static ProductList productList = new ProductList();
    private static InputMessage inputMessage = new InputMessage();
    private static OutputMessage outputMessage = new OutputMessage();
    private static int initialTotalChange;
    private static int customerMoney;

    public VendingMachine() {
        this.initializeVendingMachine();
    }

    public void run() {
        inputCustomerMoney();
        while (checkAvailableSellState()) {
            inputSellProduct();
        }
        returnChange();
    }

    private void initializeVendingMachine() {
        initialTotalChange = change.inputInitialTotalChange();
        productList.inputInitialProduct();
        createInitialChanges(initialTotalChange);
    }

    private void createInitialChanges(int initialTotalChange) {
        change.createInitialChanges(initialTotalChange);
    }

    private void returnChange() {
        change.returnChange(customerMoney);
    }

    private boolean checkAvailableSellState() {
        return productList.checkAvailableState(customerMoney);
    }

    public void sellProduct() {
        inputMessage.printBuyProductMessage();
        String productName = Console.readLine();
        validator.validateExistedProduct(productList, productName);
        validator.validateProductIsAvailable(productList, productName);
        int pay = productList.sellProduct(productName);
        customerMoney -= pay;
        outputMessage.printInputMoney(customerMoney);
    }

    public void inputSellProduct() {
        while (true) {
            try {
                sellProduct();
                break;
            } catch (IllegalArgumentException exception) {
                outputMessage.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void inputMoney() {
        inputMessage.printInputMoneyMessage();
        String money = Console.readLine();
        customerMoney = validator.validateOnlyInteger(money);
        validator.validateGreaterThanMinimumPrice(productList, customerMoney);
        outputMessage.printInputMoney(customerMoney);
    }

    public void inputCustomerMoney() {
        while (true) {
            try {
                inputMoney();
                break;
            } catch (IllegalArgumentException exception) {
                outputMessage.printErrorMessage(exception.getMessage());
            }
        }
    }
}
