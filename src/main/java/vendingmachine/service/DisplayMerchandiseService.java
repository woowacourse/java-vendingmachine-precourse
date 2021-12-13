package vendingmachine.service;

import vendingmachine.model.DisplayMerchandise;

import java.util.List;

public class DisplayMerchandiseService {
    private DisplayMerchandise displayMerchandise;

    public DisplayMerchandise createDisplayMerchandise(String[][] merchandise) {
        this.displayMerchandise = new DisplayMerchandise(merchandise);
        return this.displayMerchandise;
    }

    public boolean isExistDisplayMerchandise() {
        return displayMerchandise.isExistInventory();
    }

    public List<String> getDisplayMerchandiseNames() {
        return displayMerchandise.getDisplayMerchandiseNames();
    }
}
