package vendingmachine.utils.moneychecker;


import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.datatypechecker.IntegerChecker;

public class BalanceInputChecker {
    private static final String CONTENT_TYPE = "자판기 보유금";
    private static final int LOW_LIMIT = 0;

    public static int getBalance(){
        String input;

        do{
            input = Console.readLine();
        }while(isRightInput(input));

        return Integer.parseInt(input);
    }

    private static boolean isRightInput(String input){
        boolean isRight = true;

        try{
            IntegerChecker.checkStringToInteger(input, CONTENT_TYPE);
            IntegerChecker.checkLowLimit(Integer.parseInt(input), LOW_LIMIT, CONTENT_TYPE);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            isRight = false;
        }

        return isRight;
    }
}
