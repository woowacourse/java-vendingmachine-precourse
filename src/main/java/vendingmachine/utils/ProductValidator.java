package vendingmachine.utils;

import static vendingmachine.Constant.*;

import java.util.ArrayList;

import vendingmachine.domain.Price;
import vendingmachine.domain.Product;
import vendingmachine.domain.Quantity;

public class ProductValidator {
    public static Product validateForm(String productInfoInput) {
        StringBuffer sb = new StringBuffer(productInfoInput);
        if (!((sb.charAt(0) == '[') && (sb.charAt(productInfoInput.length() - 1) == ']'))) {
            throw new IllegalArgumentException("상품의 상태는 []로 감싸져야 합니다.");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(0);

        // split 후 안에 세 개의 문자가 있는지 확인한다.
        productInfoInput = sb.toString();
        String[] split = productInfoInput.split(",", -1);
        String name = validateProductName(split);
        Price price = new Price(split[1]);
        Quantity quantity = new Quantity(split[2]);
        // productName, [price, quantity]를 가진 걸 리턴
        return Product.registerProduct(name, price, quantity);
    }

    private static String validateProductName(String[] split) {
        if (split.length != 3) {
            throw new IllegalArgumentException("상품명, 가격, 수량이 제대로 입력되지 않았습니다.");
        }
        if (isNameEmpty(split[0])) {
            throw new IllegalArgumentException("이름이 제대로 입력되지 않은 상품이 있습니다.");
        }
        return split[0];
    }

    private static boolean isNameEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }
}
