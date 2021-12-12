package vendingmachine.model;

import java.util.List;

public class DisplayMerchandise {
    private final List<Merchandise> merchandises;

    public DisplayMerchandise(List<Merchandise> merchandises) {
        this.merchandises = merchandises;
    }
}
