package vendingmachine.utils;

import static vendingmachine.Constant.*;
import static vendingmachine.ErrorMessage.*;
import static vendingmachine.utils.StringUtil.*;

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
        if (StringUtil.isEmpty(productInfoInput)) {
            throw new IllegalArgumentException(NO_BLANK_ERROR_MESSAGE);
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
            throw new IllegalArgumentException(NO_WRAP_ERROR_MESSAGE);
        }
    }

    private static Product validateProductInfo(String productInfoInput) {
        String[] split = productInfoInput.split(PRODUCT_INFO_DELIMETER, -1);
        validateInfoCnt(split);
        String name = validateProductName(split[PRODUCT_NAME_IDX]);
        Price price = validatePrice(split[PRODUCT_PRICE_IDX]);
        Quantity quantity = new Quantity(split[PRODUCT_QUANTITY_IDX]);
        return Product.registerProduct(name, price, quantity);
    }

    private static Price validatePrice(String priceInput) {
        if (StringUtil.isEmpty(priceInput)) {
            throw new IllegalArgumentException(NO_BLANK_ERROR_MESSAGE);
        }
        int price = StringUtil.parseStringToInt(priceInput);
        if (price < 100) {
            throw new IllegalArgumentException("상품의 가격이 100원 미만인 값이 있습니다.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("상품의 가격은 0 보다 커야 합니다.");
        }
        return new Price(price);
    }

    private static void validateInfoCnt(String[] split) {
        if (split.length != PRODUCT_INFO_CNT) {
            throw new IllegalArgumentException(INVALID_PRODUCT_INFO_CNT_ERROR_MESSAGE);
        }
    }

    private static String validateProductName(String productName) {
        if (StringUtil.isEmpty(productName)) {
            throw new IllegalArgumentException(NAME_EMPTY_ERROR_MESSAGE);
        }
        return productName;
    }
}
