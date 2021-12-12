package vendingmachine.view;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;

import java.util.Map;

public class OutputView {

    public static void printVendingMachineChange(Change change) {
        Map<Coin, Integer> coinMap = change.getCoinMap();

        System.out.println("\n자판기가 보유한 동전");

        for (Coin coin : coinMap.keySet()) {
            System.out.println(coin.getAmount()+"원 - " + coinMap.get(coin)+"개");
        }
    }
}
