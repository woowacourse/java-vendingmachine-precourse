package vendingmachine.view.input;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.ProductValidator;
import vendingmachine.constant.Input;

public class ProductInputView {

    public void inputProducts() {
        while (true) {
            print(Input.PRODUCT_GUIDE_MESSAGE.getText());
            String input = Console.readLine();
            String[] products = input.split(Input.SEMICOLON.getText());

            try {
                ProductValidator productValidator = new ProductValidator();
                productValidator.tryToInputProducts(products);
                return;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void print(String message) {
        System.out.println(message);
    }
}
