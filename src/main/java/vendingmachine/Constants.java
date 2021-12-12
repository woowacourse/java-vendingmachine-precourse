package vendingmachine;

public class Constants {
    final static int[] COINS = {500, 100, 50, 10};

    final static String MACHINE_MONEY_MSG = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    final static String MACHINE_COINS_MSG = "자판기가 보유한 동전";

    final static String INPUT_MENUS_MSG = "상품명과 가격, 수량을 입력해 주세요.";
    final static String INPUT_MONEY_MSG = "투입 금액을 입력해 주세요.";
    final static String CURR_INPUT_MONEY = "투입 금액: ";
    final static String PURCHASE_MENU_MSG = "구매할 상품명을 입력해 주세요.";
    final static String CHANGES_MSG = "잔돈";
    final static String KRW = "원";
    final static String EA = "개";
    final static String MSG_DELIMETER = " - ";

    final static String ERROR = "[ERROR] ";
    final static String WRONG_INPUT_MACHINE_MONEY = "금액은 숫자여야 합니다.";
    final static String WRONG_INPUT_MENU = "잘못된 메뉴를 입력하였습니다.";
    final static String WRONG_INPUT_PURCHASE_MENU = "메뉴판에 없는 메뉴를 구매하려하였습니다.";
}
