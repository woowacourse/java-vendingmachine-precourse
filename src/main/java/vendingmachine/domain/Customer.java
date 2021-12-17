package vendingmachine.domain;

import vendingmachine.validator.ValidatorOld;
import vendingmachine.view.LoopInput;
import vendingmachine.view.OutputMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer extends LoopInput {
    private int customerMoney;
    private static final int EMPTY_STOCK = 0;
    private ArrayList<Product> products = new ArrayList<>();
    private HashMap<Coin, Integer> coinStorage = new HashMap<>();

    public Customer(int customerMoney) {
        this.customerMoney = customerMoney;
    }

    public void buyProduct(Product product) {
        products.add(product);
        customerMoney = product.calcCustomerMoney(customerMoney);
        product.sell();
    }

    public int getCustomerMoney() {
        return customerMoney;
    }

    public void addCoin(Coin coin, int returnStock) {
        if (returnStock != EMPTY_STOCK) {
            coinStorage.put(coin, returnStock);
            customerMoney -= coin.calcChangePrice(returnStock);
        }
    }

    public HashMap<Coin, Integer> getCoinStorage() {
        return coinStorage;
    }


    /******************************************************************/
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해주세요.";
    private static final ValidatorOld VALIDATOR_OLD = new ValidatorOld();
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
        customerMoney = VALIDATOR_OLD.validateOnlyInteger(money);
        VALIDATOR_OLD.validateGreaterThanMinimumPrice(productList, customerMoney);
        outputMessage.printInputMoney(customerMoney);
    }
}
