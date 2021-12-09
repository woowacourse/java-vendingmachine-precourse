package vendingmachine;

public class VendingMachine {
    private Coins coins;
    private Products products;
    private InputAmount inputAmount;

    public VendingMachine(String amount) {
        coins = new Coins(amount);
    }

    public void getBalance() {
        View.printBalance(inputAmount);
    }

    public void createProduct(String specification) {
        products = new Products(specification);
    }

    public void createInputAmount(String amount) {
        inputAmount =  new InputAmount(amount);
    }

    public void sell(String productName) {
        products.reduce(productName);
        inputAmount.reduce(products.getPriceByName(productName));
    }

}
