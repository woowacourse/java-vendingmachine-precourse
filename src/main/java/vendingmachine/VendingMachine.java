package vendingmachine;

public class VendingMachine {
    private final Products products;
    private final Coins holdingCoins;
    private int inputAmount = 0;

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

    private int deductFromInputAmount(int totalPrice) {
        int restAmount = inputAmount - totalPrice;
        return restAmount;
    }
}