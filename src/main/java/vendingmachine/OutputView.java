package vendingmachine;

import java.util.List;

public class OutputView {

    public void totalConins(List<Integer> own_coins) {

        System.out.print(Coin.COIN_500.getAmount() + "원" + " - " + own_coins.get(0) + "개" + "\n");
        System.out.print(Coin.COIN_100.getAmount() + "원" + " - " + own_coins.get(1) + "개" + "\n");
        System.out.print(Coin.COIN_50.getAmount() + "원" + " - " + own_coins.get(2) + "개" + "\n");
        System.out.print(Coin.COIN_10.getAmount() + "원" + " - " + own_coins.get(3) + "개" + "\n");
    }

    public void printAmount(int Amount) {
        System.out.print("투입 금액: " + Amount + "원" + "\n");
    }
    public void vending_changes(){
        System.out.print("자판기가 보유한 동전" + "\n");
    }
    public void changes(){
        System.out.print("잔돈" + "\n");
    }
}
