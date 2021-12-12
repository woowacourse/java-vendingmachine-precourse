package vendingmachine.management;

import java.util.ArrayList;
import java.util.List;

public class CommodityRepository {
    private static final List<Commodity> commodities = new ArrayList<>();

    public static List<Commodity> getList() {
        return commodities;
    }
    
    public static void addCommodity(Commodity commodity) {
        commodities.add(commodity);
    }
    
    public static Commodity findByName(String name) {
        return commodities.stream()
              .filter(c -> c.getName()
              .equals(name))
              .findAny()
              .orElse(null);
    }
    
    public static void reduceQuantity(Commodity commodity) {
        Commodity original =  commodity.clone();
        commodity.subtractQuantity();
        commodities.set(commodities.indexOf(original), commodity);
    }
}
