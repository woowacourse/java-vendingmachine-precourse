package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {

    private int vendingMachineCoin;

    public int inputVendingMachineCoinProcess() {
        try {
            vendingMachineCoin = inputVendingMachineCoin();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputVendingMachineCoinProcess();
        }
        return vendingMachineCoin;
    }

    private int inputVendingMachineCoin() {
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

    public List<String> inputProducts() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String products = Console.readLine();
        validateProducts(products);
        return Arrays.stream(products.split(";")).collect(Collectors.toList());
    }

    private void validateProducts(String products) {
        for (String product : products.split(";")) {
            if (!product.matches("^\\[[가-힣a-zA-Z]+,+[0-9]+,+[0-9]+\\].*")) {
                throw new IllegalArgumentException("[ERROR] 입력 포맷이 잘못되었습니다.");
            }
        }
    }
}
