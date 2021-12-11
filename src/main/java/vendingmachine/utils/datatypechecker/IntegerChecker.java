package vendingmachine.utils.datatypechecker;

public class IntegerChecker {
    static public void checkStringToInteger(String price, String contentType) throws IllegalArgumentException{

        try{
            Integer.parseInt(price);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException("[ERROR]: " + contentType + "은 양의 정수로 입력해주세요.");
        }

    }

    static public void checkLowLimit(int price, int lowLimit, String contentType) throws IllegalArgumentException{

        if(price < lowLimit){
            throw new IllegalArgumentException("[ERROR]: " + contentType + " 값은" + lowLimit +" 이상으로 설정해주세요.");
        }

    }
}
