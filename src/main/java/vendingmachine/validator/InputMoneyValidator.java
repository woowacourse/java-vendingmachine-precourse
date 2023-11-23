package vendingmachine.validator;

import vendingmachine.utils.Parser;

public class InputMoneyValidator {
    public static void validateInputMoney(String money){
        int parsedMoney = validateNotNumber(money);
        validateZeroAndNegative(parsedMoney);
        validateUnit(parsedMoney);
    }

    private static int validateNotNumber(String money){
        try{
             return Integer.parseInt(money);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 문자는 입력될 수 없습니다.");
        }
    }

    private static void validateZeroAndNegative(int parsedMoney){
        if(parsedMoney <= 0){
            throw new IllegalArgumentException("[ERROR] 음수 또는 0이 입력되었습니다. 다시 입력해 주세요.");
        }
    }

    private static void validateUnit(int parsedMoney){
        if(parsedMoney % 10 != 0){
            throw new IllegalArgumentException("[ERROR] 10원 단위로 입력되어야 합니다.");
        }
    }
}
