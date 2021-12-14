package vendingmachine.Validation;

public class ValidationVendingMachineCoin {

    public static void isInteger(String machineCoinString){
        try{
            Integer.parseInt(machineCoinString);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    public static void isPositiveCoin(String machineCoinString){
        if(Integer.parseInt(machineCoinString) < 0){
            throw new IllegalArgumentException("[ERROR] 금액은 0이상이어야 합니다.");
        }
    }

    public static void isDivideCoin(String machineCoinString){
        if(Integer.parseInt(machineCoinString)%10 != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 10원으로 나누어떨어져야 합니다.");
        }
    }

}
