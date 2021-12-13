package vendingmachine.management;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.operation.validation.CheckCommoditySelection;

public class CommodityRepository {
    private static final List<Commodity> commodities = new ArrayList<>();

    public static List<Commodity> getList() {
        return commodities;
    }
    
    public static void addCommodity(Commodity commodity) {
        commodities.add(commodity);
    }
    
    public static Commodity findByName(String name) {
        CheckCommoditySelection.validationNotRegistered(name);
        return commodities.stream()
              .filter(c -> c.getName()
              .equals(name))
              .findAny()
              .orElseThrow(IllegalArgumentException::new);
    }
    
    public static void reduceQuantity(Commodity commodity) {
        int index = commodities.indexOf(commodity);
        commodity.subtractQuantity();
        commodities.set(index, commodity);
    }
}
