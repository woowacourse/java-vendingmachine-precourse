package vendingmachine.utils;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

import java.util.Arrays;
import java.util.List;

public class VerificationUtil {

    private static final String REGEX = "^\\[[a-zA-Z가-힣]+,[1-9][0-9]+0,[1-9][0-9]*]$";
    private static final int ZERO = 0;
    private static final int UNIT = 10;

    private VerificationUtil() {
    }

    public static void validateHoldingAmount(String input) {
        int holdingAmount = getValidatedNumber(input);

        validatePositiveNumber(holdingAmount);
        validateMultipleOfTen(holdingAmount);
    }

    public static void validateProductInput(String input) {
        Arrays.stream(input.split(";"))
                .filter(s -> !s.matches(REGEX))
                .findAny()
                .ifPresent(s -> {
                    throw new IllegalArgumentException("[ERROR] 잘못된 상품 입력입니다.\n");
                });
    }

    public static void checkProduct(VendingMachine vendingMachine, String productName) {
        List<Product> productList = vendingMachine.getProductList();

        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                checkProductAmount(product);
                return;
            }
        }

        throw new IllegalArgumentException("[ERROR] 해당하는 상품이 존재하지 않습니다.\n");
    }

    public static void checkProductPrice(int productPrice) {
        if (productPrice < 100) {
            throw new IllegalArgumentException("[ERROR] 상품은 100원 이상이어야 합니다.");
        }
    }

    private static void checkProductAmount(Product product) {
        if (product.getQuantity() <= ZERO) {
            throw new IllegalArgumentException("[ERROR] 해당 상품의 재고가 없습니다.\n");
        }
    }

    private static int getValidatedNumber(String input) {
        try {
            int number = Integer.parseInt(input);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.\n");
        }
    }

    private static void validatePositiveNumber(int holdingAmount) {
        if (holdingAmount <= ZERO) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.\n");
        }
    }

    private static void validateMultipleOfTen(int holdingAmount) {
        if (holdingAmount % UNIT != ZERO) {
            throw new IllegalArgumentException("[ERROR] 10원 단위로 입력해주세요.\n");
        }
    }
}
