package vendingmachine.user;

public class UserGoodsValidation {
    public static void isEmpty(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_GOODS_IS_NULL);
        }
    }

    public static void checkBracketNumber(String input) {
        if (!checkBracketPairNumber(input)) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_SQUARE_BRACKETS);
        }
    }

    public static boolean checkBracketPairNumber(String input) {
        int countOpen = 0;
        int countClose = 0;

        for (int i=0; i<input.length(); i++) {
            String c = Character.toString(input.charAt(i));

            if (c == InputErrorConstant.SQUARE_BRACKETS_OPEN) {
                countOpen++;
            }
            if (c == InputErrorConstant.SQUARE_BRACKETS_CLOSE) {
                countClose++;
            }
        }
        return countOpen == countClose;
    }

    public static void checkHasBracket(String input) {
        if (!input.contains(InputErrorConstant.SQUARE_BRACKETS_OPEN)) {
            throw new IllegalArgumentException(InputErrorConstant.ERROR_IS_NOT_SQUARE_BRACKETS);
        }
    }
}
