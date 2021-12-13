package vendingmachine.model;

import vendingmachine.util.InputGenerator;

import java.util.ArrayList;
import java.util.List;

public class DisplayMerchandise {
    private final List<Merchandise> merchandises;

    public DisplayMerchandise(String[][] merchandise) {
        this.merchandises = initDisplayMerchandise(merchandise);
    }

    private List<Merchandise> initDisplayMerchandise(String[][] merchandiseInfo) {
        List<Merchandise> merchandises = new ArrayList<>();

        for (String[] m : merchandiseInfo) {
            Merchandise merchandise = new Merchandise(m[0],
                    InputGenerator.convertToInteger(m[1]), InputGenerator.convertToInteger(m[2]));
            merchandises.add(merchandise);
        }
        return merchandises;
    }
}
