package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {

    private final Changes changes;

    private Money money;
    private Merchandises merchandises;

    public VendingMachine(String change) {
        validChanges(change);
        this.changes = new Changes(Integer.parseInt(change));
        this.money = new Money(0);
    }

    private void validChanges(String stringChange) {
        validInteger(stringChange);
        graterThanZero(stringChange);
    }

    private void validInteger(String stringChange) {
        try {
            Integer.parseInt(stringChange);
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] : 숫자로 이루어져야 합니다.");
        }
    }

    private void graterThanZero(String stringChange) {
        Integer change = Integer.parseInt(stringChange);
        if (change < 10) {
            throw new IllegalArgumentException("[ERROR] : 잔돈은 10원 이상의 값을 입력하여야 합니다.");
        }

        if (change % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] : 상품 가격은 10원으로 나누어 떨어져야 합니다.");
        }
    }

    public void setMerchandise(String requireVendingMachineMerchandiseInfo) {
        this.merchandises = new Merchandises(requireVendingMachineMerchandiseInfo);
    }
}
