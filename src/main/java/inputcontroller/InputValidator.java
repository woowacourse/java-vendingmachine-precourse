package inputcontroller;

import static vendingmachine.VendingMachineMain.*;

public class InputValidator {

    public static void isVaildMoney(String moneyValue) {
        // 예외1. 숫자 외의 문자 포함된 경우
        isDigit(moneyValue);
        // 예외2. 10원 단위가 아님
        isMultOf10(moneyValue);
        // 입력 금액이 상품의 최소 판매가격보다 낮음
        if (Integer.parseInt(moneyValue) < minCost) {
            throw new IllegalArgumentException("[ERROR] 금액이 부족합니다.\n");
        }
    }

    public static void isDigit(String moneyValue) {
        for (int i = 0; i < moneyValue.length(); i++) {
            char digitCh = moneyValue.charAt(i);
            if (digitCh - '0' < 0 || digitCh - '0' > 9) {
                throw new IllegalArgumentException("[ERROR] 10원 단위의 정수를 입력하세요.\n");
            }
        }
    }

    public static void isMultOf10(String moneyValue) {
        int number = Integer.parseInt(moneyValue);
        if (number % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10원 단위의 정수를 입력하세요.\n");
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

    public static void isValidProduct(String productToBuy) {
        if (!name2Product.containsKey(productToBuy)) {
            throw new IllegalArgumentException("[ERROR] 상품의 이름을 확인하세요.");
        }
        if (!name2Product.get(productToBuy).provide()) {
            throw new IllegalArgumentException("[ERROR] 재고가 없습니다.");
        }
        if (userInputMoney < name2Product.get(productToBuy).value()) {
            throw new IllegalArgumentException("[ERROR] 금액이 모자랍니다.");
        }
    }
}