package vendingmachine.user;

public class UserGoodsQuantityValidation {
    public static void checkGoodsQuantityValidation(String quantity) {
        isEmpty(quantity);
        hasEmpty(quantity);
        isNumber(quantity);
        isPositive(quantity);
    }

    public static void isEmpty(String quantity) {
        if (quantity.length() == 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_QUANTITY_IS_NULL);
        }
    }

    public static void hasEmpty(String quantity) {
        if (quantity.contains(InputErrorConstant.EMPTY_SPACE)) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_QUANTITY_HAS_NULL);
        }
    }

    public static void isNumber(String quantity) {
        if (!quantity.matches("-?\\d+")) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_QUANTITY_IS_NOT_NUMBER);
        }
    }

    public static void isPositive(String quantity) {
        if (Integer.parseInt(quantity) <= 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_QUANTITY_IS_NOT_POSITIVE);
        }
    }
}
