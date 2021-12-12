package vendingmachine.user;

public class UserGoodsValidation {
    public static void isEmpty(String inputGoods) {
        if (inputGoods.length() == 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_GOODS_IS_NULL);
        }
    }

    public static void hasEmpty(String input) {
        if (input.contains(InputErrorConstant.EMPTY_SPACE)) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_HAS_SPACE);
        }
    }

    public static void isNumber(String money) {
        if (!money.matches("-?\\d+")) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_NUMBER);
        }
    }

    public static void is100WonMore(String price) {
        if (Integer.parseInt(price) >= InputErrorConstant.GOODS_PRICE_LIMIT) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_100WON_MORE);
        }
    }

    public static void dividedBy10Won(String price) {
        if (Integer.parseInt(price) % InputErrorConstant.GOODS_PRICE_RULE == 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_PRICE_RULE);
        }
    }
}
