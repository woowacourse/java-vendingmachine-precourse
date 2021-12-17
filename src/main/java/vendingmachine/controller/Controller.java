package vendingmachine.controller;

import vendingmachine.ProductDivider;
import vendingmachine.domain.Change;
import vendingmachine.domain.Customer;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductList;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    private static final InputValidator inputValidator = new InputValidator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private ProductDivider productDivider = new ProductDivider();
    private Change change;
    private Customer customer;
    private ProductList productList = new ProductList();

    public void run() {
        inputChange();
        inputProducts();
        inputMoney();
        while (checkAvailableSale()) {
            buyProduct();
        }
        returnChange();
    }

    public void inputChange() {
        try {
            inputView.printInputChange();
            String inputChange = Console.readLine();
            int intChange = inputValidator.isOnlyInteger(inputChange);
            inputValidator.isMultipleOfTen(intChange);
            change = new Change(intChange);
            outputView.printCoinList(change);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            inputChange();
        }
    }

    public void inputProducts() {
        try {
            inputView.printInputProducts();
            String products = Console.readLine();
            productList.initProductMap();
            productDivider.divideProduct(productList, products);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            inputProducts();
        }
    }

    public void inputMoney() {
        try {
            inputView.printInputMoney();
            String inputMoney = Console.readLine();
            int intMoney = inputValidator.isOnlyInteger(inputMoney);
            inputValidator.isBiggerThanMinimumPrice(productList, intMoney);
            customer = new Customer(intMoney);
            outputView.printMoney(customer.getCustomerMoney());
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            inputMoney();
        }
    }

    public void buyProduct() {
        try {
            inputView.printInputBuyProduct();
            String productName = Console.readLine();
            Product product = inputValidator.validateExistedProduct(productList, productName);
            inputValidator.validateProductIsAvailable(product);
            customer.buyProduct(product);
            outputView.printMoney(customer.getCustomerMoney());
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            buyProduct();
        }
    }

    public void returnChange() {
        change.returnChange(customer);
        outputView.printChange(customer);
    }

    public boolean checkAvailableSale() {
        return productList.checkAvailableState(customer.getCustomerMoney());
    }
}
