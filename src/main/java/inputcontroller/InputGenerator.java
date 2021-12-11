package inputcontroller;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.VendingMachineMain.*;

public class InputGenerator {

    public static int inputInitMoney() {
        String inputText;
        while (true) {
            try {
                System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
                inputText = Console.readLine();
                InputValidator.isVaildMoney(inputText);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return Integer.parseInt(inputText);
    }

    public static String[] inputInitProducts() {
        String inputText;
        String[] inputTextParsed;
        while (true) {
            try {
                System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
                inputText = Console.readLine();
                inputTextParsed = inputText.split("\\[|,|;|\\]| ");
                InputValidator.formatOfProduct(inputTextParsed);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return inputTextParsed;
    }

    public static void inputUserMoney() {
        while (true) {
            try {
                System.out.println("\n투입 금액을 입력해 주세요.");
                String inputText = Console.readLine();
                InputValidator.isVaildMoney(inputText);

                userInputMoney = Integer.parseInt(inputText);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static String inputProductToBuy() {
        String productToBuy;
        while (true) {
            try {
                System.out.printf("\n투입 금액: %d원", userInputMoney);
                System.out.println("\n구매할 상품을 입력해 주세요.");
                productToBuy = Console.readLine();
                InputValidator.isInInventory(productToBuy);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return productToBuy;
    }
}