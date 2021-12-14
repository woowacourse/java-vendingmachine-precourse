package vendingmachine.utils.moneychecker;


import camp.nextstep.edu.missionutils.Console;
import vendingmachine.servicesource.wallet.Coin;
import vendingmachine.utils.datatypechecker.IntegerChecker;

public class BalanceInputChecker {
    private static final String INPUT_REQUEST_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String CONTENT_TYPE = "자판기 보유금";
    private static final int LOW_LIMIT = 0;
    private static final int MIN_MONEY_UNIT = Coin.getMinimumAmountCoin().getAmount();

    public static int getBalance(){
        String input;

        do{
            System.out.println(INPUT_REQUEST_MESSAGE);
            input = Console.readLine();
        }while(!isRightInput(input));

        return Integer.parseInt(input);
    }

    private static boolean isRightInput(String input){
        boolean isRight = true;

        try{
            IntegerChecker.checkStringToInteger(input, CONTENT_TYPE);

            int balance = Integer.parseInt(input);
            IntegerChecker.checkLowLimit(balance, LOW_LIMIT, CONTENT_TYPE);
            IntegerChecker.checkDivideIntoMod(balance, MIN_MONEY_UNIT, CONTENT_TYPE);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            isRight = false;
        }

        return isRight;
    }
}
