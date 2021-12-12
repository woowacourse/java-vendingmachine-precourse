package vendingmachine.domain;

import java.util.Map;
import vendingmachine.domain.merchandise.Merchandises;

public class VendingMachine {

    private static final String NOT_EXIST_TARGET_MERCHANDISE = "[ERROR] : 해당 상품은 존재하지 않습니다. 존재하는 상품을 입력 부탁드립니다.";

    private final Changes changes;
    private final Money money;
    private final Merchandises merchandises;

    public VendingMachine(String stringMerchandise, Changes changes) {
        this.changes = changes;
        this.money = new Money(0);
        this.merchandises = new Merchandises(stringMerchandise);
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
            throw new IllegalArgumentException(NOT_EXIST_TARGET_MERCHANDISE);
        }
    }

    public boolean canBuySomething() {
        return money.amount() >= merchandises.cheapest();
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
