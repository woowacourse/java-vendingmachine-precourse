package vendingmachine.view;

import static vendingmachine.Messages.*;

import java.util.Map;

public class OutputView {

    //자판기 보유 금액 출력
    public void printVendingMachineCoin() {
        System.out.println(OUTPUT_VENDING_MACHINE_COIN);
    }

    //자판기 보유 동전 출력
    public void printCoins(Map<Integer, Integer> vendingMachineCoins) {
        vendingMachineCoins.forEach((key, value) -> System.out.println(key + WON_AND_HYPHEN + value + GAE));
    }

    //사용자 투입 금액 출력
    public void printUserMoney(int money) {
        System.out.printf(OUTPUT_MONEY, money);
    }

    //잔돈 출력
    public void printRemainingCoins(Map<Integer, Integer> chargeCoins, int money) {
        printUserMoney(money);
        System.out.println(OUTPUT_CHARGE);
        printCoins(chargeCoins);
    }
}
