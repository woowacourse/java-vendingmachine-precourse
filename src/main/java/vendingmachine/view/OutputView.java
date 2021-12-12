package vendingmachine.view;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class OutputView {

    private OutputView() {
    }

    public static void printVendingMachineChange(Change change) {
        Map<Coin, Integer> coinMap = change.getCoinMap();

        System.out.println("\n자판기가 보유한 동전");

        for (Coin coin : coinMap.keySet()) {
            System.out.println(coin.getAmount()+"원 - " + coinMap.get(coin)+"개");
        }
    }

    public static void printVendingMachineChangeResult(VendingMachine vendingMachine) {
        int restMoney = vendingMachine.getRestMoney();

        System.out.println("\n투입 금액: " + restMoney + "원");

        Change change = vendingMachine.returnChange();

        Map<Coin, Integer> coinMap = change.getCoinMap();

        System.out.println("잔돈");

        for (Coin coin : coinMap.keySet()) {
            if (coinMap.get(coin) > 0 && ((restMoney - coin.getAmount()) >= 0)) {
                System.out.println(coin.getAmount()+"원 - " + coinMap.get(coin)+"개");
            }
        }
    }
}
