package vendingmachine.view.outputView;

import java.util.List;

public class ManagementView {
    private static final String ASK_DEPOSIT_AMOUT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ASK_COMMODITY_INFO = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String COIN_DEPOSIT = "자판기가 보유한 동전";
    private static final String FIVE_HUNDRED_WON = "500원 - ";
    private static final String ONE_HUNDRED_WON = "100원 - ";
    private static final String FIFTY_WON = "50원 - ";
    private static final String TEN_WON = "10원 - ";
    private static final String PIECE = "개";
    
    public static void askDepositAmout() {
        System.out.println(ASK_DEPOSIT_AMOUT);
    }
    
    public static void askCommodityInfo() {
        System.out.println(ASK_COMMODITY_INFO);
    }
    
}
