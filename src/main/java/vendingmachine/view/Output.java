package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachineMoney;

public class Output {
    private static final String VENDING_HAVE_MONEY = "\n자판기가 보유한 동전";
    private static final String PRINT_BASIC_WON = "원 - ";
    private static final String PRINT_COUNT = "개";
    public static void printVendingMachineCoin(VendingMachineMoney vendingMachineMoney) {
        System.out.println(VENDING_HAVE_MONEY);
        System.out.println(Coin.COIN_500.getAmount() + PRINT_BASIC_WON + vendingMachineMoney.getMoneyCount500() + PRINT_COUNT);
        System.out.println(Coin.COIN_100.getAmount() + PRINT_BASIC_WON + vendingMachineMoney.getMoneyCount100() + PRINT_COUNT);
        System.out.println(Coin.COIN_50.getAmount() + PRINT_BASIC_WON + vendingMachineMoney.getMoneyCount50() + PRINT_COUNT);
        System.out.println(Coin.COIN_10.getAmount() + PRINT_BASIC_WON + vendingMachineMoney.getMoneyCount10() + PRINT_COUNT);
    }
}
