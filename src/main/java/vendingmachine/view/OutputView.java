package vendingmachine.view;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class OutputView {

    private static final int ZERO = 0;

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
            if (coinMap.get(coin) > ZERO && ((restMoney - coin.getAmount()) >= ZERO)) {
                System.out.println(coin.getAmount()+"원 - " + coinMap.get(coin)+"개");
            }
        }
    }

    public static String printInputVendingMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");

        return readLine();
    }

    public static String printInputVendingMachineProduct() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");

        return readLine();
    }

    public static String printInputInsertAmount() {
        System.out.println("투입 금액을 입력해 주세요.");

        return readLine();
    }

    public static String printInputProductName(int restMoney) {
        System.out.println("\n투입 금액: " + restMoney + "원");

        System.out.println("구매할 상품명을 입력해 주세요.");

        return readLine();
    }
}
