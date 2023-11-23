package vendingmachine.validator;

import vendingmachine.utils.Parser;

public class InputMoneyValidator {
    public static void validateInputMoney(String money){
        int parsedMoney = validateNotPositive(money);
        validateUnit(parsedMoney);
    }

    private static int validateNotPositive(String money){
        try{
             return Integer.parseInt(money);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수가 입력되어야 합니다.");
        }
    }

    private static void validateUnit(int parsedMoney){
        if(parsedMoney % 10 != 0){
            throw new IllegalArgumentException("[ERROR] 10원 단위로 입력되어야 합니다.");
        }
    }
}
