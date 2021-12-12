package vendingmachine.view;

import vendingmachine.Coin;

public class OutputView {

    public void printMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해주세요.");
    }

    public void printCoin() {
        System.out.println();
        System.out.println("자판기가 보유한 동전");
        for (Coin coin : Coin.values()) {
            System.out.println(coin.getAmount() + "원 - " + coin.getStock() + "개");
        }
    }

}
