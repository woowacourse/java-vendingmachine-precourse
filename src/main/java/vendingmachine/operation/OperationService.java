package vendingmachine.operation;

import vendingmachine.management.Commodity;
import vendingmachine.management.CommodityRepository;
import vendingmachine.operation.validation.CheckCommoditySelection;

public class OperationService {
    public static int calculateBalance(Commodity commodity, int balance) {
        CheckCommoditySelection.validationOutOfBalance(commodity, balance);
        CheckCommoditySelection.validationSoldOut(commodity);
        return balance - commodity.getPrice();
    }

    public static void reduceCommodityQuantity(Commodity commodity) {
        CommodityRepository.reduceQuantity(commodity);
    }
}
