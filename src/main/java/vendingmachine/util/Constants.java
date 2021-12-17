package vendingmachine.util;

public class Constants {
    public static final String ENTER_MACHINE_MONEY_MSG = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String WRONG_MACHINE_MONEY = "잘못된 금액을 입력하셨습니다. 최소 단위 10원.";
    public static final String WRONG_MACHINE_MENU = "잘못된 상품명, 가격, 수량을 입력하셨습니다.";
    public static final String WRONG_MENU_STOCK = "구매하려는 상품의 재고가 없습니다.";
    public static final String WRONG_MENU_NAME = "구매하려는 상품의 이름이 없습니다.";

    public static final String TAKEN_MACHINE_COINS_MSG = "자판기가 보유한 동전";
    public static final String KRW = "원";
    public static final String EA = "개";
    public static final String ENTER_MACHINE_MENUS_MSG = "상품명과 가격, 수량을 입력해 주세요.";
    public static final String ENTER_USER_MONEY_MSG = "투입 금액을 입력해 주세요.";
    public static final String USER_MONEY = "투입 금액: ";
    public static final String ENTER_USER_PURCHASE_MENU = "구매할 상품명을 입력해 주세요.";
    public static final String CHANGES_MSG = "잔돈";
    public static final String ERROR_MSG = "[ERROR] ";

    public static final String MACHINE_MONEY_PATTERN = "^[1-9]+[0-9]*[0]+$";
    public static final String MACHINE_MENUS_PATTERN= "^\\[([가-힣]+),([1-9]+[0-9]*),([1-9]+[0-9]*)\\]$";

    public static final String COINS_MSG_DELIMETER = " - ";
    public static final String SPLIT_MENUS_DELIMETER = ";";
    public static final String SPLIT_ITEMS_DELIMETER = ",";

}
