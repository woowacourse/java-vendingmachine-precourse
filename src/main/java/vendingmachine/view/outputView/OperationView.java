package vendingmachine.view.outputView;

public class OperationView {
    private static final String ASK_INSERTION_AMOUNT = "투입 금액을 입력해 주세요.";
    private static final String SHOW_BALANCE = "투입 금액: ";
    private static final String WON = "원";
    private static final String ASK_COMMODITY = "구매할 상품명을 입력해 주세요.";
    
    public static void askInsertionAmount() {
        System.out.println(ASK_INSERTION_AMOUNT);
    }
    
    public static void showBalance(int balance) {
        System.out.println(SHOW_BALANCE + balance + WON);
    }
    
    public static void askCommodity() {
        System.out.println(ASK_COMMODITY);
    }

}
