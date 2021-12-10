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

    private static void validateInputIsEmpty(String productInfoInput) {
        if (isEmpty(productInfoInput)) {
            throw new IllegalArgumentException("공백은 입력될 수 없습니다.");
        }
    }

    private static String removeBracket(String productInfoInput) {
        StringBuffer temp = new StringBuffer(productInfoInput);
        validateInputWrapBracket(temp);
        temp.deleteCharAt(temp.length() - 1);
        temp.deleteCharAt(0);
        return temp.toString();
    }

    private static void validateInputWrapBracket(StringBuffer sb) {
        if (!((sb.charAt(0) == INPUT_WRAP_START) && (sb.charAt(sb.length() - 1) == INPUT_WRAP_END))) {
            throw new IllegalArgumentException("상품의 상태는 []로 감싸져야 합니다.");
        }
    }

    private static Product validateProductInfo(String productInfoInput) {
        String[] split = productInfoInput.split(PRODUCT_INFO_DELIMETER, -1);
        validateInfoCnt(split);
        String name = validateProductName(split[PRODUCT_NAME_IDX]);
        Price price = new Price(split[PRODUCT_PRICE_IDX]);
        Quantity quantity = new Quantity(split[PRODUCT_QUANTITY_IDX]);
        return Product.registerProduct(name, price, quantity);
    }

    private static void validateInfoCnt(String[] split) {
        if (split.length != PRODUCT_INFO_CNT) {
            throw new IllegalArgumentException("상품명, 가격, 수량이 제대로 입력되지 않았습니다.");
        }
    }

    private static String validateProductName(String productName) {
        if (isEmpty(productName)) {
            throw new IllegalArgumentException("이름이 제대로 입력되지 않은 상품이 있습니다.");
        }
        return productName;
    }
}
