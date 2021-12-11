package vendingmachine.management.validation;

public class CheckCommodityFormat {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] 입력이 형식에 맞지 않습니다.";

    public static void validation(String [] commodities) {

        for(int i = 0; i < commodities.length; i++) {
            String [] commodityInfo = commodities[i].split(",",-1);
            
            if(commodityInfo.length != 3) {
                throw new IllegalArgumentException(ERROR_MESSAGE_FORMAT);
            }
        }
    }
}
