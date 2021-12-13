package vendingmachine.view.outputView;

import java.util.Map;

import vendingmachine.Coin;

public class OperationView {
    private static final String ASK_INSERTION_AMOUNT = "투입 금액을 입력해 주세요.";
    private static final String SHOW_BALANCE = "투입 금액: ";
    private static final String WON = "원";
    private static final String ASK_COMMODITY = "구매할 상품명을 입력해 주세요.";
    private static final String BALANCE = "잔돈";
    private static final String NUMBER = "개";
    private static final String HYPHEN = " - ";
    
    public static void askInsertionAmount() {
        System.out.println(ASK_INSERTION_AMOUNT);
    }
    
    public static void showBalance(int balance) {
        System.out.println(SHOW_BALANCE + balance + WON);
    }
    
    public static void askCommodity() {
        System.out.println(ASK_COMMODITY);
    }
    
    public static void showBalanceReturn(Map<Coin,Integer> map) {
        System.out.println(BALANCE);
        for(Coin c : map.keySet()) {
            if(map.get(c) == 0) {
                continue;
            }
            System.out.println(c.getAmount() + WON + HYPHEN + map.get(c) + NUMBER);
        }
    }
}
