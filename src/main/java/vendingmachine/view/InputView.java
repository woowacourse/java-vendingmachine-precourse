package vendingmachine.view;

import static vendingmachine.Messages.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputVendingMachineCoin() {
        System.out.println(INPUT_VENDING_MACHINE_COIN);
        String vendingMachineCoin = Console.readLine();
        validateVendingMachineCoin(vendingMachineCoin);
        return Integer.parseInt(vendingMachineCoin);
    }

    private void validateVendingMachineCoin(String vendingMachineCoin) {
        if (!vendingMachineCoin.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ERROR_INPUT_VENDING_MACHINE_COIN);
        }
    }

    public String inputProducts() {
        System.out.println(INPUT_PRODUCTS);
        String products = Console.readLine();
        validateProducts(products);
        return products;
    }

    private void validateProducts(String products) {
        for (String product : products.split(";")) {
            if (!product.matches("^\\[[가-힣a-zA-Z]+,+[0-9]+,+[0-9]+\\].*")) {
                throw new IllegalArgumentException(ERROR_INPUT_PRODUCTS);
            }
        }
    }

    public int inputMoney() {
        System.out.println(INPUT_MONEY);
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        if (money.matches("^[0-9]$")) {
            throw new IllegalArgumentException(ERROR_INPUT_MONEY);
        }
    }

    public String inputProductName() {
        System.out.println(INPUT_PRODUCT_NAME);
        return Console.readLine();
    }
}