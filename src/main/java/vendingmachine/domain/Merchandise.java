package vendingmachine.domain;

public class Merchandise {

    private final String name;
    private final int cost;

    private int count;

    public Merchandise(String merchandise) {

        String[] merchandiseInfo = merchandise
            .substring(1, merchandise.length() - 1)
            .split(",");

        validStartEndformat(merchandise);
        validMerchandisFormat(merchandiseInfo);
        validCost(merchandiseInfo[1]);
        validCount(merchandiseInfo[2]);

        this.name = merchandiseInfo[0];
        this.cost = Integer.parseInt(merchandiseInfo[1]);
        this.count = Integer.parseInt(merchandiseInfo[2]);


    }

    private void validCount(String stringCount) {
        int count = 0;
        try {
            count = Integer.parseInt(stringCount);
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] : 상품 수량은 숫자로 이루어져야 합니다.");
        }

        if (count <= 0) {
            throw new IllegalArgumentException("[ERROR] : 상품 수량은 1개 이상 존재해야 합니다.");
        }
    }

    private void validCost(String stringCost) {
        int cost = 0;
        try {
            cost = Integer.parseInt(stringCost);
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] : 가격은 숫자로 이루어져야 합니다.");
        }

        if (cost < 100) {
            throw new IllegalArgumentException("[ERROR] : 상품 가격은 100원 이상이어야 합니다.");
        }
        if (cost % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] : 상품 가격은 10원으로 나누어 떨어져야 합니다.");
        }
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
        return name;
    }

    public int cost() {
        return cost;
    }

    public int count() {
        return count;
    }

    public void buy() {
        this.count--;
    }
}
