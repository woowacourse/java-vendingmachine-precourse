package vendingmachine.utils;

import static vendingmachine.Constant.*;

import java.util.ArrayList;

import vendingmachine.domain.Price;
import vendingmachine.domain.Quantity;

public class ProductValidator {
    public static String validateForm(String productInfoInput) {
        StringBuffer sb = new StringBuffer(productInfoInput);
        if (!((sb.charAt(0) == '[') && (sb.charAt(productInfoInput.length() - 1) == ']'))) {
            throw new IllegalArgumentException("상품의 상태는 []로 감싸져야 합니다.");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(0);

        // split 후 안에 세 개의 문자가 있는지 확인한다.
        productInfoInput = sb.toString();
        String[] split = productInfoInput.split(",", -1);
        if (split.length != 3) {
            throw new IllegalArgumentException("상품명, 가격, 수량이 제대로 입력되지 않았습니다.");
        }
        if (isNameEmpty(split[0])) {
            throw new IllegalArgumentException("이름이 제대로 입력되지 않은 상품이 있습니다.");
        }
        //split[1]은 Price, split[2]는 Quantity
        Price price = new Price(split[1]);
        Quantity quantity = new Quantity(split[2]);
        // productName, [price, quantity]를 가진 걸 리턴
        return new Product(split[0], price, quantity);
    }

    private static boolean isNameEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }
}
