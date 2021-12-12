package vendingmachine.utils.productchecker;

import vendingmachine.utils.datatypechecker.IntegerChecker;
import vendingmachine.utils.datatypechecker.StringChecker;

public class PriceChecker {
    static private final int MOD = 10;
    static private final int LOW_LIMIT = 100;
    static private final String CONTENT_TYPE = "가격";

    static void checkPrice(String price) throws IllegalArgumentException {
        StringChecker.checkStringLength(price, CONTENT_TYPE);
        IntegerChecker.checkStringToInteger(price, CONTENT_TYPE);

        int priceToInteger = Integer.parseInt(price);
        IntegerChecker.checkLowLimit(priceToInteger, LOW_LIMIT, CONTENT_TYPE);
        IntegerChecker.checkDivideIntoMod(priceToInteger, MOD, CONTENT_TYPE);
    }
}
