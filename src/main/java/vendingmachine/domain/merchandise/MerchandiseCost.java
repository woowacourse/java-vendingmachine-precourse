package vendingmachine.domain.merchandise;

public class MerchandiseCost {

    private static final String MERCHANDISE_COST_IS_INTEGER = "[ERROR] : 가격은 숫자로 이루어져야 합니다.";
    private static final String MERCHANDISE_COST_IS_OVER_THAN_100 = "[ERROR] : 상품 가격은 100원 이상이어야 합니다.";
    private static final String MERCHANDISE_COST_IS_MULTIPLE_OF_10 = "[ERROR] : 상품 가격은 10원으로 나누어 떨어져야 합니다.";
    private static final Integer MINIMUM_COST = 100;
    private static final Integer MULTIPLE_THRETHOLD = 10;

    private final Integer cost;

    public MerchandiseCost(String cost) {
        validCost(cost);
        this.cost = Integer.parseInt(cost);
    }

    private void validCost(String stringCost) {
        int cost = 0;
        try {
            cost = Integer.parseInt(stringCost);
        } catch (Exception exception) {
            throw new IllegalArgumentException(MERCHANDISE_COST_IS_INTEGER);
        }

        if (cost < MINIMUM_COST) {
            throw new IllegalArgumentException(MERCHANDISE_COST_IS_OVER_THAN_100);
        }
        if (cost % MULTIPLE_THRETHOLD != 0) {
            throw new IllegalArgumentException(MERCHANDISE_COST_IS_MULTIPLE_OF_10);
        }
    }

    public int cost() {
        return cost;
    }
}
