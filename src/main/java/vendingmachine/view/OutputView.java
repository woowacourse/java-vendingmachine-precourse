package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.repository.Coin;

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

    public void printMachineProduct() {
        System.out.println("상품과 가격, 수량을 입력해 주세요.");
    }

    public void printOrderMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
    }

    public void printInputMoney(int money) {
        System.out.println("투입 금액: " + money + "원");

    }

    public void printProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
    }

    public void printReturnCoin() {
        System.out.println("잔돈");
    }

    public void printCoinResult(HashMap<Coin, Integer> map){

        for (Coin coin: Coin.values()){
            System.out.println(coin.getAmount()+"원 - " + map.get(coin)+"개");
        }

    }

}
