package vendingmachine.user;

public class UserGoodsValidation {
    public static void is100WonMore(String price) {
        if (Integer.parseInt(price) >= 100) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_100WON_MORE);
        }
    }
}
