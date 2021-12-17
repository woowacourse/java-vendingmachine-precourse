package vendingmachine.view;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Customer;

import java.util.HashMap;

public class OutputView {

    public void printCoinList(Change change) {
        HashMap<Coin, Integer> coinStorage = change.getCoinStorage();
        // 출력 기능 수행
    }

    public void printMoney(int money) {
        System.out.println("투입 금액: " + money + "원");
    }

    public void printChange(Customer customer) {

    }

}
