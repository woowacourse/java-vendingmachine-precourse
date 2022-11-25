package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputVendingMachineCoin() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String vendingMachineCoin = Console.readLine();
        validateVendingMachineCoin(vendingMachineCoin);
        return Integer.parseInt(vendingMachineCoin);
    }

    private void validateVendingMachineCoin(String vendingMachineCoin) {
        if (!vendingMachineCoin.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public String inputProducts() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String products = Console.readLine();
        validateProducts(products);
        return products;
    }

    private void validateProducts(String products) {
        for (String product : products.split(";")) {
            if (!product.matches("^\\[[가-힣a-zA-Z]+,+[0-9]+,+[0-9]+\\].*")) {
                throw new IllegalArgumentException("[ERROR] 입력 포맷이 잘못되었습니다.");
            }
        }
    }

    public int inputMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        if (money.matches("^[0-9]$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
