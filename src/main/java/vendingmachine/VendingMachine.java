package vendingmachine;

public class VendingMachine {
    private static final int ZERO = 0;

    private final Products products;
    private final Coins holdingCoins;
    private int inputAmount = ZERO;

    public VendingMachine(String products, int holdingMoney) {
        this.products = new Products(products);
        this.holdingCoins = new Coins(holdingMoney);
    }

    public void buy(String productName, int productQuantity) {
        int totalPrice = products.takeOut(productName, productQuantity);
        inputAmount = deductFromInputAmount(totalPrice);
    }

    public void insertMoney(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    private void validatePurchasable(int restAmount) {
        if (isExceedRestAmount(restAmount)) {
            throw new IllegalArgumentException("잔액을 초과하여 구매할 수 없습니다.");
        }
    }

    private boolean isExceedRestAmount(int restAmount) {
        return restAmount < ZERO;
    }

    private int deductFromInputAmount(int totalPrice) {
        int restAmount = inputAmount - totalPrice;
        validatePurchasable(restAmount);

        return restAmount;
    }

}