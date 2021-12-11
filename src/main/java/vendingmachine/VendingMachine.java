package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachine {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final Change change = new Change();
    private static ProductList productList = new ProductList();
    private static InputMessage inputMessage = new InputMessage();
    private static int InitialTotalChange;
    private static int customerMoney;

    public VendingMachine() {
        initializeVendingMachine();
    }

    public void run() {
        inputCustomerMoney();
        while (checkAvailableSellState()) {
            inputSellProduct();
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
        inputMessage.printInputMoneyMessage();
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
        inputMessage.printBuyProductMessage();
        String product = Console.readLine();
        this.validateSellProduct(product);
        int pay = productList.sellProduct(product);
        customerMoney -= pay;
        printInputMoney();
    }

    private void validateSellProduct(String product) {
        this.validateExistedProduct(product);
        this.validateProductIsAvailable(product);
    }

    private void validateExistedProduct(String product) {
        if (!productList.findProductByName(product)) {
            throw new IllegalArgumentException("입력한 상품이 존재하지 않습니다.");
        }
    }

    private void validateProductIsAvailable(String product) {
        if (!productList.isAvailableProduct(product)) {
            throw new IllegalArgumentException("입력한 상품의 재고가 없습니다.");
        }
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

    public void inputSellProduct() {
        while (true) {
            try {
                this.sellProduct();
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
