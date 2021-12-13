package vendingmachine.service;

import vendingmachine.model.DisplayMerchandise;

public class DisplayMerchandiseService {

    public DisplayMerchandise createDisplayMerchandise(String[][] merchandise) {
        return new DisplayMerchandise(merchandise);
    }
}
