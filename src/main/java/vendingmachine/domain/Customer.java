package vendingmachine.domain;

import vendingmachine.validator.Validator;
import vendingmachine.view.LoopInput;
import vendingmachine.view.OutputMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer extends LoopInput {
    private int customerMoney;
    private ArrayList<Product> products = new ArrayList<>();
    private HashMap<Coin, Integer> coinStorage = new HashMap<>();

    public Customer(int customerMoney) {
        this.customerMoney = customerMoney;
    }

    public void buyProduct(Product product) {
        products.add(product);
        customerMoney = product.calcCustomerMoney(customerMoney);
    }

    public int getCustomerMoney() {
        return customerMoney;
    }












    /******************************************************************/
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해주세요.";
    private static final Validator validator = new Validator();
    private static ProductList productList = new ProductList();
    private static OutputMessage outputMessage = new OutputMessage();

    public Customer() {

    }

    public void inputMethod() {
        this.inputCustomerMoney();
    }

//    public int getCustomerMoney() {
//        return customerMoney;
//    }

    public void calcCustomerMoney(Product product) {
        customerMoney = product.calcCustomerMoney(customerMoney);
    }

    private void inputCustomerMoney() {
        String money = inputString(INPUT_MONEY_MESSAGE);
        customerMoney = validator.validateOnlyInteger(money);
        validator.validateGreaterThanMinimumPrice(productList, customerMoney);
        outputMessage.printInputMoney(customerMoney);
    }
}
