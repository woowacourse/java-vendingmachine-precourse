package view;

import model.Coin;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class OutputView {

    private static final String OUTPUT_VENDING_MACHINE_MESSAGE = "자판기가 보유한 동전";
    private static final String WON = "원";
    private static final String UNIT = "개";
    private static final String BAR = " - ";
    private static final String OUTPUT_REMAINING_MONEY_MESSAGE = "투입 금액: ";
    private static final String OUTPUT_CHANGE_MESSAGE = "잔돈";
    public void printErrorMessage(Exception e){
        System.out.println(e.getMessage());
    }

    public void printVendingMachineCoin(){
        System.out.println(OUTPUT_VENDING_MACHINE_MESSAGE);
        Arrays.stream(Coin.values())
                .forEach(coin-> System.out.println(coin.getAmount()+WON+BAR+coin.getNum()+UNIT));
    }

    public void printRemainingMoney(int money){
        System.out.println("\n"+OUTPUT_REMAINING_MONEY_MESSAGE+money+WON);
    }

    public void printChange(List<List<Integer>> change){
        System.out.println(OUTPUT_CHANGE_MESSAGE);
        change.stream()
                .filter(c -> c.get(1) > 0)
                .forEach(coin -> System.out.println(coin.get(0) + WON + BAR + coin.get(1) + UNIT));
    }
}
