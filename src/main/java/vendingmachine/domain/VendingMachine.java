package vendingmachine.domain;

import vendingmachine.view.InputView;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        List<Integer> coinCombination = coinGenerator.generate(amount);
        AtomicInteger index = new AtomicInteger();
        Coin.stream()
            .forEach(coin -> {
                System.out.println(coin.toString() + " - " + coinCombination.get(index.get()) + "개");
                index.addAndGet(1);
            });
    }


}


