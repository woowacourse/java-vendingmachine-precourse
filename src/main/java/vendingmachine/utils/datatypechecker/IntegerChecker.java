package vendingmachine.utils.datatypechecker;

public class IntegerChecker {
    static public void checkStringToInteger(String value, String contentType) throws IllegalArgumentException{

        try{
            Integer.parseInt(value);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException("[ERROR]: " + contentType + "은 정수 형태로 입력해주세요.");
        }

    }

    static public void checkLowLimit(int value, int lowLimit, String contentType) throws IllegalArgumentException{

        if(value < lowLimit){
            throw new IllegalArgumentException("[ERROR]: " + contentType + " 값은" + lowLimit +" 이상으로 설정해주세요.");
        }

    }

    public static void checkDivideIntoMod(int value, int mod, String contentType) throws IllegalArgumentException{

        if(value % mod != 0){
            throw new IllegalArgumentException("[ERROR]: "+ contentType +"은(는) " + mod +" 원으로 나누어 떨어져야 합니다.");
        }

    }
}
