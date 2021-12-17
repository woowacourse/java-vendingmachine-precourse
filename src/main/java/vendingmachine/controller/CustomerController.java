package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Customer;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductList;
import vendingmachine.view.CustomerInputView;

public class CustomerController {
    /**
     * 1. 고객이 금액을 넣는다
     * 2. 물품을 구매한다.
     * 3. 잔액을 반환 받는다.
     */
    private Customer customer;
    private CustomerInputView customerInputView = new CustomerInputView();

    public void inputMoney() {
        customerInputView.printInputMoney();
        String stringMoney = Console.readLine();
        customer = new Customer(Integer.parseInt(stringMoney));
    }

    public void buyProduct(Product product) {
        customer.buyProduct(product);
    }

    public String inputProduct() {
        customerInputView.printInputProduct();
        String product = Console.readLine();
        return product;
    }
}
