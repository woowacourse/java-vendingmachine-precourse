package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {

    private final Changes changes;

    private Money money;
    private Merchandises merchandises;

    public VendingMachine(String change) {
        this.changes = new Changes(change);
        this.money = new Money(0);
    }

    public VendingMachine(String stringMerchandise, Changes changes) {
        this.changes = changes;
        this.money = new Money(0);
        this.merchandises = new Merchandises(stringMerchandise);
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
