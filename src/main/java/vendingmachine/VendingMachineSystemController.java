package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;
import vendingmachine.domain.Customer;
import vendingmachine.domain.VendingMachine;
import vendingmachine.system.message.SystemErrorMessage;
import vendingmachine.system.message.SystemInputMessage;
import vendingmachine.system.validation.Validation;
import vendingmachine.system.validation.ValidationImplementation;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachineSystemController {
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
                printConsoleMessage(SystemInputMessage.INPUT_HOLDING_MONEY_MESSAGE.getMessage());
                holdingMoney = Console.readLine();
                isValidInput = validation.isValidHoldingMoney(holdingMoney);
            } catch (IllegalArgumentException e) {
                printConsoleMessage(SystemErrorMessage.ERROR_INPUT_HOLDING_MONEY_MESSAGE.getMessage());
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
                printConsoleMessage(SystemInputMessage.INPUT_PRODUCT_PRICE_STOCK_MESSAGE.getMessage());
                productNameAndPriceAndStocks = Console.readLine();
                isValidInput = validation.isValidProductNameAndPriceAndStock(productNameAndPriceAndStocks);
            } catch (IllegalArgumentException e) {
                printConsoleMessage(SystemErrorMessage.ERROR_PRODUCT_PRICE_STOCK_MESSAGE.getMessage());
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
                printConsoleMessage(SystemInputMessage.INPUT_USER_INSERT_MONEY_MESSAGE.getMessage());
                String userInsertMoney = Console.readLine();
                isValidInput = validation.isValidUserInsertMoney(userInsertMoney);
                userInputMoney = toInteger(userInsertMoney);
            } catch (IllegalArgumentException e) {
                printConsoleMessage(SystemErrorMessage.ERROR_USER_INSERT_MONEY_MESSAGE.getMessage());
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
                printConsoleMessage(SystemInputMessage.INPUT_PRODUCT_NAME_TO_BUY_MESSAGE.getMessage());
                productNameToBuy = Console.readLine();
                isValidInput = validation.isValidProductNameToBuy(productNameToBuy);
            } catch (IllegalArgumentException e) {
                printConsoleMessage(SystemErrorMessage.ERROR_PRODUCT_NAME_TO_BUY_MESSAGE.getMessage());
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
