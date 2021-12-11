package inputcontroller;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.VendingMachineMain.*;

public class InputGenerator {

    public static int inputInitMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String inputText = Console.readLine();
        InputValidator.isVaildMoney(inputText);

        return Integer.parseInt(inputText);
    }

    public static String[] inputInitProducts() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
        String inputText = Console.readLine();
        String[] inputTextParsed = inputText.split("\\[|,|;|\\]| ");
        InputValidator.formatOfProduct(inputTextParsed);

        return inputTextParsed;
    }

    public static void inputUserMoney() {
        System.out.println("\n투입 금액을 입력해 주세요.");
        String inputText = Console.readLine();
        InputValidator.isVaildMoney(inputText);

        userInputMoney = Integer.parseInt(inputText);
    }

    public static String inputProductToBuy() {
        System.out.printf("\n투입 금액: %d원", userInputMoney);
        System.out.println("\n구매할 상품을 입력해 주세요.");
        String productToBuy = Console.readLine();
        return productToBuy;
    }
}