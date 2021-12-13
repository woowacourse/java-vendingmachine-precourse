package vendingmachine.service;

import vendingmachine.repository.Money;
import vendingmachine.repository.Product;
import vendingmachine.repository.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class OrderService {
    OutputView outputView = new OutputView();
    Money money;

    public void get(Products products){
        outputView.printOrderMoney();
        getUserMoney();


    }

    public void getUserMoney(){
        InputView inputView = new InputView();
        money.setMoney(Integer.parseInt(inputView.getMoney()));

    }
}
