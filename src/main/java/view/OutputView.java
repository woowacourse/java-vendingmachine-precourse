package view;

import model.Coin;

public class OutputView {

    private static final String OUTPUT_VENDING_MACHINE_MESSAGE = "자판기가 보유한 동전";
    private static final String WON = "원";
    private static final String UNIT = "개";
    private static final String BAR = " - ";
    private static final String OUTPUT_REMAINING_MONEY_MESSAGE = "투입 금액: ";

    public void printErrorMessage(Exception e){
        System.out.println(e.getMessage());
    }

    public void printVendingMachineCoin(){
        System.out.println(OUTPUT_VENDING_MACHINE_MESSAGE);
        for (Coin coin : Coin.values()) {
            System.out.println(coin.getAmount()+WON+BAR+coin.getNum()+UNIT);
        }
    }

    public void printRemainingMoney(int money){
        System.out.println("\n"+OUTPUT_REMAINING_MONEY_MESSAGE+money);
    }
}
