package vendingmachine.user;

public class UserGoodsNameValidation {
    public static void checkGoodsNameValidation(String name) {
        isEmpty(name);
        hasEmpty(name);
    }

    public static void isEmpty(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_GOODS_NAME_IS_NULL);
        }
    }

    public static void hasEmpty(String name) {
        if (name.contains(InputErrorConstant.EMPTY_SPACE)) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_GOODS_NAME_HAS_NULL);
        }
    }


}
