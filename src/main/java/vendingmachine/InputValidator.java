package vendingmachine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface InputValidator {

    public static final String PRODUCT_INFO_INPUT_REGEX = "^(\\[[a-zA-Z가-힣0-9]+,[0-9]+,[0-9]+\\])(;\\[[a-zA-Z가-힣0-9]+,[0-9]+,[0-9]+\\])*$";

    static void validateInsertedAmount(String insertedAmount) {
        if (insertedAmount.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INSERTED_AMOUNT.getCompleteMessage());
        }

        for (int i = 0 ; i < insertedAmount.length() ; i++ ) {
            if(!Character.isDigit(insertedAmount.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INSERTED_AMOUNT.getCompleteMessage());
            }
        }

        if (Integer.parseInt(insertedAmount) % 10 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_BY_10.getCompleteMessage());
        }
    }

    static void validateProductInfoInput(String productInfoInput) {
        Pattern productInfoPattern = Pattern.compile(PRODUCT_INFO_INPUT_REGEX);
        Matcher productInfoMatcher = productInfoPattern.matcher(productInfoInput);
        if (!productInfoMatcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRODUCT_INFO_FORMAT.getCompleteMessage());
        }
    }

    static void validateProductPrice(int productPrice) {
        if (productPrice < 100 && (productPrice % 10) != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRODUCT_PRICE.getCompleteMessage());
        }
    }
}
