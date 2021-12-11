package vendingmachine;

public class Message {
    public static final String INPUT_MACHINE_BALANCE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String ERROR_MACHINE_BALANCE_BLANK = "[ERROR] 공백은 입력이 불가능합니다.";
    public static final String ERROR_MACHINE_BALANCE_CHARACTER = "[ERROR] 실수 혹은 (숫자가 아닌 문자)는 입력이 불가능합니다.";
    public static final String ERROR_MACHINE_BALANCE_NEGATIVE_NUMBER = "[ERROR] 음수는 입력이 불가능합니다.";
    public static final String ERROR_MACHINE_BALANCE_MULTIPLE_OF_TEN = "[ERROR] 10의 배수가 아닌 수는 입력이 불가능합니다.";
    public static final String SHOW_MACHINE_COINS = "자판기가 보유한 동전";
    public static final String INPUT_MACHINE_Goods = "상품명과 가격, 수량을 입력해 주세요.";
    public static final String ERROR_MACHINE_Goods_INVAILD_INPUT_SQUARE_BRACKETS = "[ERROR] 잘못된 입력입니다. 상품정보는 대괄호로 시작하고 끝나야 합니다. (eg. [상품명,가격,수량])";
    public static final String ERROR_MACHINE_Goods_INVAILD_INPUT_COMMA = "[ERROR] 잘못된 입력입니다. 상품명, 가격, 수량은 쉼표로 구분되어야 합니다. (eg. [상품명,가격,수량])";
    public static final String ERROR_MACHINE_Goods_INVAILD = "[ERROR] 잘못된 입력입니다. (eg. [상품명,가격,수량])";
    public static final String ERROR_MACHINE_Goods_INVAILD_PRICE = "[ERROR] 잘못된 입력입니다. 상품의 가격은 100원 이상이여야 합니다.";
    public static final String ERROR_MACHINE_Goods_INVAILD_QUANTITY = "[ERROR] 잘못된 입력입니다. 상품의 수량은 0개 이상이여야 합니다.";
    public static final String INPUT_USER_AMOUNT = "투입 금액을 입력해 주세요.";
    public static final String INPUT_BUY_PRODUCT = "구매할 상품명을 입력해 주세요.";
    public static final String REMAINING_AMOUNT = "투입 금액: ";
    public static final String WON = "원";
    public static final String ERROR_GOODS_NO_FIND = "[ERROR] 해당하는 상품이 없습니다.";
    public static final String ERROR_GOODS_NO_INVENTORY = "[ERROR] 해당하는 상품의 재고가 없습니다.";
    public static final String RETURN_BALANCE = "잔돈";
    public static final String WON_SPACE_BAR_SPACE = "원 - ";
    public static final String QUANTITY = "개";




}
