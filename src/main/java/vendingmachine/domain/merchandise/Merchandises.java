package vendingmachine.domain.merchandise;

import java.util.ArrayList;
import java.util.List;

public class Merchandises {

    private static final String DUPLICATE_ERROR = "상품명은 중복 불가입니다.";
    private static final String DELIMITER = ";";

    private List<Merchandise> merchandises = new ArrayList<>();

    public Merchandises(String vendingMachineMerchandises) {
        validMerchandise(vendingMachineMerchandises);

    }

    private void validMerchandise(String vendingMachineMerchandises) {
        addMerchandise(vendingMachineMerchandises);
        checkDuplicateMerchandise();
    }

    private void checkDuplicateMerchandise() {
        int distinctMerchandiseCount = (int) merchandises.stream()
            .map(merchandise -> merchandise.name()).distinct()
            .count();
        int merchandiseCount = merchandises.size();
        if (distinctMerchandiseCount != merchandiseCount) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private void addMerchandise(String vendingMachineMerchandises) {
        String[] merchandises = vendingMachineMerchandises.split(DELIMITER);
        for (String merchandise : merchandises) {
            this.merchandises.add(new Merchandise(merchandise));
        }
    }

    public void buy(String targetMerchandise) {
        Merchandise merchandise = findMerchandise(targetMerchandise);
        merchandise.buy();
    }

    private Merchandise findMerchandise(String targetMerchandise) {
        Merchandise merchandise = merchandises.stream()
            .filter(m -> m.name().equals(targetMerchandise))
            .findFirst()
            .get();

        return merchandise;
    }

    public int cheapest() {
        return merchandises.stream()
            .filter(merchandise -> merchandise.count() > 0)
            .map(Merchandise::cost)
            .min(Integer::compare)
            .orElse(0);
    }

    public Integer cost(String targetMerchandise) {
        return merchandises.stream()
            .filter(merchandise -> merchandise.name().equals(targetMerchandise))
            .findFirst()
            .get()
            .cost();
    }

    public boolean soldOut() {
        return merchandises.stream().allMatch(merchandise -> merchandise.count() == 0);
    }

    public boolean exist(String targetMerchandise) {
        return merchandises.stream()
            .anyMatch(merchandise -> merchandise.name().equals(targetMerchandise));
    }
}
