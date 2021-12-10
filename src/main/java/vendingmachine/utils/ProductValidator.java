package vendingmachine.utils;

import static vendingmachine.Constant.*;
import static vendingmachine.utils.StringUtil.*;

import java.util.ArrayList;

import vendingmachine.domain.Price;
import vendingmachine.domain.Product;
import vendingmachine.domain.Quantity;

public class ProductValidator {
    public static Product validateForm(String productInfoInput) {
        validateInputIsEmpty(productInfoInput);
        productInfoInput = removeBracket(productInfoInput);
        Product product = validateProductInfo(productInfoInput);
        return product;
    }

    private static Product validateProductInfo(String productInfoInput) {
        String[] split = productInfoInput.split(",", -1);
        String name = validateProductName(split);
        Price price = new Price(split[1]);
        Quantity quantity = new Quantity(split[2]);
        return Product.registerProduct(name, price, quantity);
    }

    private static String removeBracket(String productInfoInput) {
        StringBuffer temp = new StringBuffer(productInfoInput);
        validateInputWrapBracket(temp);
        temp.deleteCharAt(temp.length() - 1);
        temp.deleteCharAt(0);
        return temp.toString();
    }

    private static void validateInputWrapBracket(StringBuffer sb) {
        if (!((sb.charAt(0) == '[') && (sb.charAt(sb.length() - 1) == ']'))) {
            throw new IllegalArgumentException("상품의 상태는 []로 감싸져야 합니다.");
        }
    }

    private static void validateInputIsEmpty(String productInfoInput) {
        if (isEmpty(productInfoInput)) {
            throw new IllegalArgumentException("공백은 입력될 수 없습니다.");
        }
    }

    private static String validateProductName(String[] split) {
        if (split.length != 3) {
            throw new IllegalArgumentException("상품명, 가격, 수량이 제대로 입력되지 않았습니다.");
        }
        if (isEmpty(split[0])) {
            throw new IllegalArgumentException("이름이 제대로 입력되지 않은 상품이 있습니다.");
        }
        return split[0];
    }
}
