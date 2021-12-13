package vendingmachine.service;

import vendingmachine.repository.Money;
import vendingmachine.repository.Product;
import vendingmachine.repository.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class OrderService {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    OrderValidator orderValidator = new OrderValidator();
    Money money;

    public void get(Products products) {
        outputView.printOrderMoney();
        getUserMoney();

    }

    public void getUserMoney() {
        while (true) {
            try {
                String tempMoney = inputView.getMoney();
                orderValidator.isValidMoney(tempMoney);
                money = new Money(Integer.parseInt(tempMoney));
                return;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}