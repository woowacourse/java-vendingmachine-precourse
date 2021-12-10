package inputcontroller;

import camp.nextstep.edu.missionutils.Console;
import models.Product;

import static vendingmachine.VendingMachineMain.name2Product;

public class InputGenerator {

    public static int inputInitMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String inputText = Console.readLine();
        InputValidator.isVaildMoney(inputText);

        return Integer.parseInt(inputText);
    }

    public static void inputInitProducts() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
        String inputText = Console.readLine();
        String[] inputTextParsed = inputText.split("\\[|,|;|\\]| ");
        InputValidator.formatOfProduct(inputTextParsed);

        for (int i = 0; i < inputTextParsed.length; i++) {
            if (i % 5 == 1) { // 상품명
                name2Product.put(inputTextParsed[i], new Product(inputTextParsed[i], Integer.parseInt(inputTextParsed[i + 1]), Integer.parseInt(inputTextParsed[i + 2])));
            }
        }
    }
}