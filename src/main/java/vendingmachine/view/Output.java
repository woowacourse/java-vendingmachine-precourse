package vendingmachine.view;

import vendingmachine.domain.VendingMachineMoney;

public class Output {
    public static void printVendingMachineCoin(VendingMachineMoney vendingMachineMoney){
        System.out.println("\n자판기가 보유한 동전");
        System.out.println("500원 - " + vendingMachineMoney.getMoneyCount500() + "개");
        System.out.println("100원 - " + vendingMachineMoney.getMoneyCount100() + "개");
        System.out.println("50원 - " + vendingMachineMoney.getMoneyCount50() + "개");
        System.out.println("10원 - " + vendingMachineMoney.getMoneyCount10() + "개");
    }
}
