package vendingmachine.user;

public class UserGoodsPriceValidation {
    public static void checkGoodsPriceValidation(String price) {
        isEmpty(price);
        hasEmpty(price);
        isNumber(price);
        isPositive(price);
        is100WonMore(price);
        dividedBy10Won(price);
    }

    public static void isEmpty(String price) {
        if (price.length() == 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_PRICE_IS_NULL);
        }
    }

    public static void hasEmpty(String price) {
        if (price.contains(InputErrorConstant.EMPTY_SPACE)) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_PRICE_HAS_NULL);
        }
    }

    public static void isNumber(String price) {
        if (!price.matches("-?\\d+")) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_PRICE_IS_NOT_NUMBER);
        }
    }

    public static void isPositive(String price) {
        if (Integer.parseInt(price) <= 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_PRICE_IS_NOT_POSITIVE);
        }
    }

    public static void is100WonMore(String price) {
        if (Integer.parseInt(price) < InputErrorConstant.GOODS_PRICE_LIMIT) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_100WON_MORE);
        }
    }

    public static void dividedBy10Won(String price) {
        if (Integer.parseInt(price) % InputErrorConstant.GOODS_PRICE_RULE != 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_PRICE_RULE);
        }
    }
}
