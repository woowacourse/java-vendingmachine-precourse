package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class VendingMachine {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final Change change = new Change();
    private static ProductList productList = new ProductList();
    private static int InitialTotalChange;
    private static int customerMoney;

    public VendingMachine() {
        initializeVendingMachine();
    }

    public void run() {
        inputCustomerMoney();
        while (checkAvailableSellState()) {
            sellProduct();
        }
        returnChange();
    }

    private void returnChange() {
        change.returnChange(customerMoney);
    }

    private boolean checkAvailableSellState() {
        return productList.checkAvailableState(customerMoney);
    }
    public void inputCustomerMoney() {
        while (true) {
            try {
                inputMoney();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE_PREFIX + exception.getMessage());
            }
        }
    }
    private void inputMoney() {
        System.out.println("투입 금액을 입력해주세요.");
        String money = Console.readLine();
        customerMoney = this.validateCustomerMoney(money);
        printInputMoney();
    }

    private int validateCustomerMoney(String money) {
        int inputMoney = this.validateOnlyNumber(money);
        this.validateGreaterThanMinimumPrice(inputMoney);
        return inputMoney;
    }

    private void validateGreaterThanMinimumPrice(int money) {
        if (!productList.compareMinimumPrice(money)) {
            throw new IllegalArgumentException("투입 금액보다 저렴한 상품이 없습니다.");
        }
    }

    private int validateOnlyNumber(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("투입 금액은 숫자만 입력할 수 있습니다.");
        }
    }


    public void sellProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        String product = Console.readLine();
        int pay = productList.sellProduct(product);
        customerMoney -= pay;
        printInputMoney();
    }

    public void printInputMoney() {
        System.out.println("투입 금액 : " + customerMoney + "원");
    }

    private void initializeVendingMachine() {
        inputInitialTotalChange();
        inputInitialProduct();
        change.createInitialChanges(InitialTotalChange);
    }

    public void inputInitialTotalChange() {
        while (true) {
            try {
                InitialTotalChange = change.insertChange();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE_PREFIX + exception.getMessage());
            }
        }
    }

    public void inputInitialProduct() {
        while (true) {
            try {
                productList.insertProduct();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE_PREFIX + exception.getMessage());
            }
        }
    }
}
