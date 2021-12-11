package vendingmachine.utils.productchecker;

import vendingmachine.utils.datatypechecker.IntegerChecker;
import vendingmachine.utils.datatypechecker.StringChecker;

public class StockChecker {
    static private final int LOW_LIMIT = 0;
    static private final String CONTENT_TYPE = "수량";

    static void checkStock(String stock) throws IllegalArgumentException{
        StringChecker.checkStringLength(stock, CONTENT_TYPE);
        IntegerChecker.checkStringToInteger(stock, CONTENT_TYPE);

        IntegerChecker.checkLowLimit(Integer.parseInt(stock), LOW_LIMIT, CONTENT_TYPE);
    }

}
