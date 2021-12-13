package vendingmachine.utils.datatypechecker;

import vendingmachine.constants.StringConstants;

public class IntegerChecker {
    //Error Message suffix
    public static final String NOT_INTEGER = "은(는) 정수 형태로 입력해주세요.";
    public static final String LOWER_THAN_LIMIT = " 이상으로 설정해주세요.";
    public static final String NOT_DIVIDED = " 원으로 나누어 떨어져야 합니다.";

    public static void checkStringToInteger(String value, String contentType) throws IllegalArgumentException{

        try{
            Integer.parseInt(value);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException(StringConstants.ERROR_MESSAGE_PREFIX + contentType + NOT_INTEGER);
        }

    }

    public static  void checkLowLimit(int value, int lowLimit, String contentType) throws IllegalArgumentException{

        if(value < lowLimit){
            String errorMessage = StringConstants.ERROR_MESSAGE_PREFIX + contentType + StringConstants.SUBJECT_SUFFIX + lowLimit +LOWER_THAN_LIMIT;
            throw new IllegalArgumentException(errorMessage);
        }

    }

    public static void checkDivideIntoMod(int value, int mod, String contentType) throws IllegalArgumentException{

        if(value % mod != 0){
            String errorMessage = StringConstants.ERROR_MESSAGE_PREFIX + contentType +StringConstants.SUBJECT_SUFFIX + mod + NOT_DIVIDED;
            throw new IllegalArgumentException(errorMessage);
        }

    }
}
