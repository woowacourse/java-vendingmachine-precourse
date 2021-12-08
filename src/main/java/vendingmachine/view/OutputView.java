package vendingmachine.view;

public class OutputView {
    public static final String PRINT_LEFT_COINS = "자판기가 보유한 동전";
    public static final String PRINT_LEFT_INSERT_MONEY = "투입 금액: ";
    public static final String PRINT_CHANGE_COINS = "잔돈";
    public static final String PRINT_COUNT_UNIT = "개";
    public static final String PRINT_WON = "원";

    public static void printSystemMessage(String message){
        System.out.println(message);
    }

    public static void breakLine(){
        System.out.println();
    }
}
