package vendingmachine.Validation;

public class ValidationUserCoin {
    public static void isIntegerAmount(String amount){
        try{
            Integer.parseInt(amount);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }
}
