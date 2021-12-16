package vendingmachine.domain;

import vendingmachine.validator.Validator;
import vendingmachine.view.LoopInput;
import vendingmachine.view.OutputMessage;

public class Customer extends LoopInput {
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해주세요.";
    private static final Validator validator = new Validator();
    private static ProductList productList = new ProductList();
    private static OutputMessage outputMessage = new OutputMessage();
    private static int customerMoney;

    public void inputMethod() {
        this.inputCustomerMoney();
    }

    public int getCustomerMoney() {
        return customerMoney;
    }

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
