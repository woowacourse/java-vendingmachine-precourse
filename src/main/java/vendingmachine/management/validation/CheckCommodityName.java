package vendingmachine.management.validation;

import java.util.List;

import vendingmachine.management.Commodity;

public class CheckCommodityName {
    private static final String ERROR_MESSAGE_Duplicate = "[ERROR] 상품 이름이 중복되었습니다.";
    
    public static void validation(List<Commodity> list, String name) {
        if(list.stream().anyMatch(c -> c.getName().equals(name))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_Duplicate);
        }   
    }
}
