package vendingmachine.domain.merchandise;

public class Merchandise {

    private final MerchandiseName merchandiseName;
    private final MerchandiseCost merchandiseCost;
    private final MerchandiseCount merchandiseCount;

    public Merchandise(String merchandise) {

        String[] merchandiseInfo = merchandise
            .substring(1, merchandise.length() - 1)
            .split(",");

        validStartEndformat(merchandise);
        validMerchandisFormat(merchandiseInfo);

        merchandiseName = new MerchandiseName(merchandiseInfo[0]);
        merchandiseCost = new MerchandiseCost(merchandiseInfo[1]);
        merchandiseCount = new MerchandiseCount(merchandiseInfo[2]);
    }

    private void validStartEndformat(String merchandise) {
        if (!merchandise.startsWith("[") && !merchandise.endsWith("]")) {
            throw new IllegalArgumentException("[ERROR] : 상품명과 가격 수량을 대괄호( [] ) 내에 입력해 주시기 바랍니다");
        }
    }

    private void validMerchandisFormat(String[] merchandiseInfo) {
        if (merchandiseInfo.length != 3) {
            throw new IllegalArgumentException("상품명과 가격 수량을 ,로 구분하여 입력해 주시기 바랍니다.");
        }
    }

    public String name() {
        return merchandiseName.name();
    }

    public int cost() {
        return merchandiseCost.cost();
    }

    public int count() {
        return merchandiseCount.count();
    }

    public void buy() {
        merchandiseCount.minus();
    }
}
