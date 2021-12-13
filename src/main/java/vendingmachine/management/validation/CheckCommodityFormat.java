package vendingmachine.management.validation;

public class CheckCommodityFormat {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] 입력이 형식에 맞지 않습니다.";
    private static final char SQUARE_BRACKET_OPEN = '[';
    private static final char SQUARE_BRACKET_CLOSE = ']';

    public static void validation(String [] commodities) {

        for(int i = 0; i < commodities.length; i++) {
            String [] commodityInfo = commodities[i].split(",",-1);
            
            if(commodityInfo.length != 3) {
                throw new IllegalArgumentException(ERROR_MESSAGE_FORMAT);
            }
        }
    }
    
    public static void validationSquareBracket(String commodity) {
        if(commodity.charAt(0) != SQUARE_BRACKET_OPEN) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FORMAT);
        }
        if(commodity.charAt(commodity.length()-1) != SQUARE_BRACKET_CLOSE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FORMAT);
        }
    }
}
