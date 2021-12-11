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
        checkPriceCanDivided(priceToInteger);
    }

    private static void checkPriceCanDivided(int price) throws IllegalArgumentException{

        if(price % MOD != 0){
            throw new IllegalArgumentException("[ERROR]: 상품의 가격은 " + MOD +" 원으로 나누어 떨어져야 합니다.");
        }

    }

}
