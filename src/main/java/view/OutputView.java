package view;

import vendingmachine.MachineAmount;
import vendingmachine.Coin;
import vendingmachine.CoinCounter;

import java.util.Map;

public class OutputView {

    public static void printVendingMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public static void printVendingMachineCoinAmount(CoinCounter coinCounter, MachineAmount amount) {
        System.out.println();
        System.out.println("자판기가 보유한 동전");
        Map<Coin, Integer> counterMap = coinCounter.getCounter(amount);

        for(Map.Entry<Coin, Integer> entry : counterMap.entrySet()) {
            Coin coin = entry.getKey();
            int count = entry.getValue();
            System.out.println(coin.displayCoinName() + " : " + count + "개");
        }
    }

    public static void printOrderDetails() {
        System.out.println();
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
    }

    public static void printInputAmount() {
        System.out.println();
        System.out.println("투입 금액을 입력해 주세요.");
    }
}
