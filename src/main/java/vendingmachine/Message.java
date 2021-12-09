package vendingmachine;

public class Message {
    public static final String INPUT_MACHINE_BALANCE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String ERROR_MACHINE_BALANCE_BLANK = "[ERROR] 공백은 입력이 불가능합니다.";
    public static final String ERROR_MACHINE_BALANCE_CHARACTER = "[ERROR] 실수 혹은 (숫자가 아닌 문자)는 입력이 불가능합니다.";
    public static final String ERROR_MACHINE_BALANCE_NEGATIVE_NUMBER = "[ERROR] 음수는 입력이 불가능합니다.";
    public static final String ERROR_MACHINE_BALANCE_MULTIPLE_OF_TEN = "[ERROR] 10의 배수가 아닌 수는 입력이 불가능합니다.";
}
