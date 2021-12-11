package inputcontroller;

public class InputValidator {

    public static void isVaildMoney(String moneyValue) {
        // 예외1. 숫자 외의 문자 포함된 경우
        isDigit(moneyValue);
        // 예외2. 10원 단위가 아님
        isMultOf10(moneyValue);
    }

    public static void isDigit(String moneyValue) {
        for (int i = 0; i < moneyValue.length(); i++) {
            char digitCh = moneyValue.charAt(i);
            if (digitCh - '0' < 0 || digitCh - '0' > 9) {
                throw new IllegalArgumentException("[ERROR] 10원 단위의 정수를 입력하세요.");
            }
        }
    }

    public static void isMultOf10(String moneyValue) {
        int number = Integer.parseInt(moneyValue);
        if (number % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10원 단위의 정수를 입력하세요.");
        }
    }

    public static void formatOfProduct(String[] inputTextParsed) {
        for (int i = 0; i < inputTextParsed.length; i++) {
            isValidContent(i, inputTextParsed[i]);
        }
    }

    public static void isValidContent(int i, String content) {
        if (1 <= i % 5 && i % 5 <= 3 && content.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 형식 [상품명,가격,수량];[상품명,가격,수량]");
        }
        if (!(1 <= i % 5 && i % 5 <= 3) && !content.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 형식 [상품명,가격,수량];[상품명,가격,수량]");
        }

        if (i % 5 == 2) { // 가격
            isVaildMoney(content);
        }
        if (i % 5 == 3) { // 수량
            isDigit(content);
        }
    }
}