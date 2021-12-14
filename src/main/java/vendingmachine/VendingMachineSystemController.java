package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;
import vendingmachine.domain.Customer;
import vendingmachine.domain.VendingMachine;
import vendingmachine.system.Validation;
import vendingmachine.system.ValidationImplementation;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachineSystemController {
    private static final String INPUT_HOLDING_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ERROR_INPUT_HOLDING_MONEY_MESSAGE = "[ERROR] 금액은 100 이상 그리고 1억 이하의 숫자이여야 하며 10으로 나누어 떨어져야 합니다.";
    private static final String INPUT_PRODUCT_PRICE_STOCK_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String ERROR_PRODUCT_PRICE_STOCK_MESSAGE = "[ERROR] [{상품명},{가격},{수량}] 형식으로 입력하셔야 하며 공백이 포함되선 안됩니다. 상품 구분자는 ';' 입니다.";
    private static final String INPUT_USER_INSERT_MONEY_MESSAGE = "투입 금액을 입력해주세요.";
    private static final String ERROR_USER_INSERT_MONEY_MESSAGE = "[ERROR] 투입 금액은 1억 이하의 숫자이여야 하며 10으로 나누어 떨어져야 합니다.";
    private static final String INPUT_PRODUCT_NAME_TO_BUY_MESSAGE = "구매할 상품명을 입력해주세요.";
    private static final String ERROR_PRODUCT_NAME_TO_BUY_MESSAGE = "[ERROR] 상품명은 한글로 입력해야 합니다. 또는 존재하지 않습니다.";
    private final Validation validation;

    public VendingMachineSystemController() {
        validation = new ValidationImplementation();
    }

    public void start() {
        int holdingMoney = inputHoldingMoney();
        VendingMachine vendingMachine = new VendingMachine(holdingMoney);
        printConsoleMessage(vendingMachine.toString());
        List<Product> products = inputProductNameAndPriceAndStock();
        vendingMachine.saveProduct(products);
        int customerInsertMoney = inputCustomerInsertMoney();
        Customer customer = new Customer(customerInsertMoney);
        vendingMachine.settingPutMoneyCustomer(customer);
        while (vendingMachine.isProductsAvailableForPurchase()) {
            printConsoleMessage(vendingMachine.toStringCustomerInputMoney());
            String productNameToBuy = inputProductNameToBuy();
            vendingMachine.pay(productNameToBuy);
        }
        printConsoleMessage(vendingMachine.toStringCustomerInputMoney());
        printConsoleMessage(vendingMachine.printCustomerChange());
    }

    public int inputHoldingMoney() {
        boolean isValidInput = false;
        String holdingMoney = "-1";
        do {
            try {
                printConsoleMessage(INPUT_HOLDING_MONEY_MESSAGE);
                holdingMoney = Console.readLine();
                isValidInput = validation.isValidHoldingMoney(holdingMoney);
            } catch (IllegalArgumentException e) {
                printConsoleMessage(ERROR_INPUT_HOLDING_MONEY_MESSAGE);
                isValidInput = false;
            }
        } while (!isValidInput);
        return Integer.parseInt(holdingMoney);
    }

    public List<Product> inputProductNameAndPriceAndStock() {
        boolean isValidInput = false;
        String productNameAndPriceAndStocks = "";
        do {
            try {
                printConsoleMessage(INPUT_PRODUCT_PRICE_STOCK_MESSAGE);
                productNameAndPriceAndStocks = Console.readLine();
                isValidInput = validation.isValidProductNameAndPriceAndStock(productNameAndPriceAndStocks);
            } catch (IllegalArgumentException e) {
                printConsoleMessage(ERROR_PRODUCT_PRICE_STOCK_MESSAGE);
                isValidInput = false;
            }
        } while (!isValidInput);
        return parsing(productNameAndPriceAndStocks);
    }

    private List<Product> parsing(String productNameAndPriceAndStocks) {
        List<String> streamProductInformation = Arrays.stream(productNameAndPriceAndStocks.split(";")).collect(Collectors.toList());
        List<Product> results = new ArrayList<>();
        for (String productInformation : streamProductInformation) {
            String removeProductInformation = removeBracket(productInformation);
            String[] productNameAndPriceAndQuantity = removeProductInformation.split(",");
            String productName = productNameAndPriceAndQuantity[0];
            int price = toInteger(productNameAndPriceAndQuantity[1]);
            int quantity = toInteger(productNameAndPriceAndQuantity[2]);
            results.add(new Product(productName, price, quantity));
        }
        return results;
    }

    private String removeBracket(String productInformation) {
        return productInformation.substring(1, productInformation.length() - 1);
    }

    public int inputCustomerInsertMoney() {
        boolean isValidInput = false;
        int userInputMoney = 0;
        do {
            try {
                printConsoleMessage(INPUT_USER_INSERT_MONEY_MESSAGE);
                String userInsertMoney = Console.readLine();
                isValidInput = validation.isValidUserInsertMoney(userInsertMoney);
                userInputMoney = toInteger(userInsertMoney);
            } catch (IllegalArgumentException e) {
                printConsoleMessage(ERROR_USER_INSERT_MONEY_MESSAGE);
                isValidInput = false;
            }
        } while (!isValidInput);
        return userInputMoney;
    }

    public String inputProductNameToBuy() {
        boolean isValidInput = false;
        String productNameToBuy = "";
        do {
            try {
                printConsoleMessage(INPUT_PRODUCT_NAME_TO_BUY_MESSAGE);
                productNameToBuy = Console.readLine();
                isValidInput = validation.isValidProductNameToBuy(productNameToBuy);
            } catch (IllegalArgumentException e) {
                printConsoleMessage(ERROR_PRODUCT_NAME_TO_BUY_MESSAGE);
                isValidInput = false;
            }
        } while (!isValidInput);
        return productNameToBuy;
    }

    public int toInteger(String stringType) {
        return Integer.parseInt(stringType);
    }

    public void printConsoleMessage(String message) {
        System.out.println(message);
    }

}
