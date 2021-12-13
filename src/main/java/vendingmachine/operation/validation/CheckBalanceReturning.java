package vendingmachine.operation.validation;

import vendingmachine.management.CommodityRepository;

public class CheckBalanceReturning {
    public static boolean hasNoBalance(int balance) {
        if(CommodityRepository.getList().stream().anyMatch(c -> c.getPrice() <= balance)) {
            return false;
        }
        return true;
    }
    
    public static boolean hasNoStock() {
        if(CommodityRepository.getList().stream().anyMatch(c -> c.getQuantity() > 0)) {
            return false;
        }
        return true;
    }


}
