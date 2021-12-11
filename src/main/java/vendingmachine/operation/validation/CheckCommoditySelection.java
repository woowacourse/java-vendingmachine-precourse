package vendingmachine.operation.validation;

import java.util.List;

import vendingmachine.management.Commodity;

public class CheckCommoditySelection {
    private static final String IS_NOT_REGISTERED = "[ERROR] 해당 상품이 존재하지 않습니다.";
    
    public static void validationIsNotRegistered(List<Commodity> inventory, String name) {
        if(!inventory.stream().anyMatch(c -> c.getName().equals(name))) {
            throw new IllegalArgumentException(IS_NOT_REGISTERED);
        }
    }
}
