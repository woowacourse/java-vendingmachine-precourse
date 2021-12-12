package vendingmachine.domain;

public class MerchandiseCount {

    private static final String MERCHANDISE_COUNT_IS_INTEGER = "[ERROR] : 상품 수량은 숫자로 이루어져야 합니다.";
    private static final String MERCHANDISE_COUNT_IS_MORE_THAN_ONE = "[ERROR] : 상품 수량은 1개 이상 존재해야 합니다.";

    private Integer count;

    public MerchandiseCount(String count) {
        validCount(count);
        this.count = Integer.parseInt(count);
    }

    private void validCount(String stringCount) {
        int count = 0;
        try {
            count = Integer.parseInt(stringCount);
        } catch (Exception exception) {
            throw new IllegalArgumentException(MERCHANDISE_COUNT_IS_INTEGER);
        }

        if (count <= 0) {
            throw new IllegalArgumentException(MERCHANDISE_COUNT_IS_MORE_THAN_ONE);
        }
    }

    public void minus() {
        this.count --;
    }

    public int count() {
        return count;
    }
}
