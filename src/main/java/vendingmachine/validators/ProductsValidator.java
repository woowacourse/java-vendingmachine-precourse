package vendingmachine.validators;

import java.util.List;

public class ProductsValidator {
    private static final int MINIMAL_PRODUCT_COUNT = 1;
    private static final String BOUNDARY_EXCEPTION = String.format("상품의 최소 수량은 %d개 이상입니다", MINIMAL_PRODUCT_COUNT);

    public static void validate(final List<Integer> counts) {
        counts.stream().forEach(ProductsValidator::isBoundary);
    }

    private static void isBoundary(final int count) {
        if (count < MINIMAL_PRODUCT_COUNT) {
            throw new IllegalArgumentException(BOUNDARY_EXCEPTION);
        }
    }
}
