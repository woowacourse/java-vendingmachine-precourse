package vendingmachine.domain;

import vendingmachine.view.InputView;

import java.util.List;

public class VendingMachine {
    private int amount;
    public VendingMachine() {
    }

    private void setAmount() {
        amount = Integer.parseInt(InputView.getUserInput());
    }

    public void print() {
        System.out.println("금액을 입력하시오");
        setAmount();
        CoinGenerator coinGenerator = new CoinGenerator();
        List<Integer> run = coinGenerator.generate(amount);
        for (Integer integer : run) {
            System.out.println(integer);
        }
    }
}

