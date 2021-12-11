package vendingmachine.operation.validation;

import java.util.List;

import vendingmachine.management.Commodity;

public class CheckCommoditySelection {
    private static final String IS_NOT_REGISTERED = "[ERROR] 해당 상품이 존재하지 않습니다.";
    private static final String IS_SOLD_OUT = "[ERROR] 해당 상품이 품절 되었습니다.";
    
    public static void validationIsNotRegistered(List<Commodity> inventory, String name) {
        if(!inventory.stream().anyMatch(c -> c.getName().equals(name))) {
            throw new IllegalArgumentException(IS_NOT_REGISTERED);
        }
    }
    
    public static void validationSoldOut(Commodity commodity) {
        if(commodity.getQuantity() < 1) {
            throw new IllegalArgumentException(IS_SOLD_OUT);
        }
    }
}
