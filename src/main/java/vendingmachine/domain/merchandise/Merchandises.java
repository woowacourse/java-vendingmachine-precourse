package vendingmachine.domain.merchandise;

import java.util.ArrayList;
import java.util.List;

public class Merchandises {

    private List<Merchandise> merchandises = new ArrayList<>();

    public Merchandises(String vendingMachineMerchandises) {
        validMerchandise(vendingMachineMerchandises);
        setMerchandiseList(vendingMachineMerchandises);
        checkDuplicateMerchandise();
    }

    private void validMerchandise(String vendingMachineMerchandises) {
        validStart(vendingMachineMerchandises);
        validEnd(vendingMachineMerchandises);
    }

    private void validEnd(String vendingMachineMerchandises) {
        if (!vendingMachineMerchandises.endsWith("]")) {
            throw new IllegalArgumentException("[ERROR] : 상품 목록 끝은 대괄호(])로 끝나야 합니다.");
        }
    }

    private void validStart(String vendingMachineMerchandises) {
        if (!vendingMachineMerchandises.startsWith("[")) {
            throw new IllegalArgumentException("[ERROR] : 상품 목록 시작은 대괄호([)로 시작하여야 합니다.");
        }
    }

    private void checkDuplicateMerchandise() {
        int distinctMerchandiseCount = (int) merchandises.stream()
            .map(merchandise -> merchandise.name()).distinct()
            .count();
        int merchandiseCount = merchandises.size();
        if (distinctMerchandiseCount != merchandiseCount) {
            throw new IllegalArgumentException("상품명은 중복 불가입니다.");
        }
    }

    private void setMerchandiseList(String vendingMachineMerchandises) {
        String[] merchandises = vendingMachineMerchandises.split(";");
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
        return merchandises.stream().anyMatch(merchandise -> merchandise.name().equals(targetMerchandise));
    }
}
