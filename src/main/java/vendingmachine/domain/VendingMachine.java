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

    public Changes changes() {
        return changes;
    }

    public Map<Integer, Integer> getChanges() {
        return changes.changes();
    }

    public void putMoney(String stringMoney) {
        this.money.add(stringMoney);
    }

    public void buyMerchandise(String targetMerchandise) {
        validTargetMerchandise(targetMerchandise);
        merchandises.buy(targetMerchandise);
        Integer cost = merchandises.cost(targetMerchandise);
        money.spend(cost);
    }

    private void validTargetMerchandise(String targetMerchandise) {
        if (!merchandises.exist(targetMerchandise)) {
            throw new IllegalArgumentException("[ERROR] : 해당 상품은 존재하지 않습니다. 존재하는 상품을 입력 부탁드립니다.");
        }
    }

    public boolean canBuySomething() {
        return money.amount() >= merchandises.cheapest();
    }

    public void setMerchandise(String requireVendingMachineMerchandiseInfo) {
        this.merchandises = new Merchandises(requireVendingMachineMerchandiseInfo);
    }

    public int money() {
        return money.amount();
    }

    public Map<Integer, Integer> calculateChangeToCustomer() {

        return changes.calculateChangeToCustomer(money.amount());
    }

    public boolean soldOut() {
        return merchandises.soldOut();
    }
}
