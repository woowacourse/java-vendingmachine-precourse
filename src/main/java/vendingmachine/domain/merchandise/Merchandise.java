package vendingmachine.domain.merchandise;

public class Merchandise {

    private static final String FRONT_BRACKETS = "[";
    private static final String END_BRACKETS = "]";
    private static final String DELIMITER = ",";
    private static final String MERCHANDISE_FORMAT_ERROR = "[ERROR] : 상품명과 가격 수량을 대괄호( [] ) 내에 입력해 주시기 바랍니다";
    private static final String MERCHANDISE_SPLIT_ERROR = "상품명과 가격 수량을 ,로 구분하여 입력해 주시기 바랍니다.";

    private final MerchandiseName merchandiseName;
    private final MerchandiseCost merchandiseCost;
    private final MerchandiseCount merchandiseCount;

    public Merchandise(String merchandise) {

        String[] merchandiseInfo = merchandise
            .substring(1, merchandise.length() - 1)
            .split(DELIMITER);

        validStartEndformat(merchandise);
        validMerchandisFormat(merchandiseInfo);

        merchandiseName = new MerchandiseName(merchandiseInfo[0]);
        merchandiseCost = new MerchandiseCost(merchandiseInfo[1]);
        merchandiseCount = new MerchandiseCount(merchandiseInfo[2]);
    }

    private void validStartEndformat(String merchandise) {
        if (!merchandise.startsWith(FRONT_BRACKETS) && !merchandise.endsWith(END_BRACKETS)) {
            throw new IllegalArgumentException(MERCHANDISE_FORMAT_ERROR);
        }
    }

    private void validMerchandisFormat(String[] merchandiseInfo) {
        if (merchandiseInfo.length != 3) {
            throw new IllegalArgumentException(MERCHANDISE_SPLIT_ERROR);
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
