package vendingmachine;

public class InputValidator {

    public static void isVaildMoney(String moneyValue) {
        // 예외1. 숫자 외의 문자 포함된 경우
        for (int i = 0; i < moneyValue.length(); i++) {
            char digitCh = moneyValue.charAt(i);
            if (digitCh - '0' < 0 || digitCh - '0' > 9) {
                throw new IllegalArgumentException("[ERROR] 10원 단위의 정수를 입력하세요");
            }
        }
        // 예외2. 10원 단위가 아님
        int number = Integer.parseInt(moneyValue);
        if (number % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10원 단위의 정수를 입력하세요");
        }
    }
}