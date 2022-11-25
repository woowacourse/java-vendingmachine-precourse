package vendingmachine;

public class VendingMachine {
    private final RemainingCoins remainingCoins;
    private final Stocks stocks;
    private final UsersMoney usersMoney;

    public VendingMachine(RemainingCoins remainingCoins, Stocks stocks, UsersMoney usersMoney) {
        this.remainingCoins = remainingCoins;
        this.stocks = stocks;
        this.usersMoney = usersMoney;
    }

    public boolean isPurchasable() {
        // 1. 존재하는가?
        // 2. 살 수 있는가?
        // - 현재 남은 금액 >= 해당 상품 금액
        // - 그 상품 남았는지
        // 3. 살 수 있다면 그만큼의 재고, 사용자 금액 반영 !
        return true;
    }

    public int getUsersMoney() {
        return usersMoney.getMoney();
    }
}
