package vendingmachine.model;

import vendingmachine.util.ErrorMessage;
import vendingmachine.util.InputGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayMerchandise {
    private static final int NONE = 0;
    private final List<Merchandise> merchandises;

    public DisplayMerchandise(String[][] merchandise) {
        this.merchandises = initDisplayMerchandise(merchandise);
    }

    public int getMinPriceMerchandise() {
        return merchandises.stream()
                .filter(merchandise -> merchandise.getInventory() > NONE)
                .mapToInt(Merchandise::getPrice)
                .min().orElse(NONE);
    }

    public boolean isExistInventory() {
        return merchandises.stream()
                .anyMatch(merchandise -> merchandise.getInventory() > NONE);
    }

    public List<String> getDisplayMerchandiseNames() {
        return merchandises.stream()
                .filter(merchandise -> merchandise.getInventory() > NONE)
                .map(Merchandise::getName)
                .collect(Collectors.toList());
    }

    public Merchandise decreaseMerchandiseInventory(String name) {
        Merchandise soldMerchandise = merchandises.stream()
                .filter(merchandise -> merchandise.getName().equals(name) && merchandise.getInventory() > NONE)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(ErrorMessage.ERROR_SOLD_OUT_MERCHANDISE.getMessage()));

        soldMerchandise.decreaseInventory();
        return soldMerchandise;
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
