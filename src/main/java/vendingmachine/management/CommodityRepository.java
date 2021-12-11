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
}
