package vendingmachine.model;

public class VendingMachine {
    private static final int MIN_PRODUCT_PRICE = 0;

    private Products products;
    private Money changes;
    private int payment;

    public VendingMachine(int totalMoney, Products products) {
        this.changes = new Money(totalMoney);
        this.products = products;
    }

    public void pay(int payment) {
        this.payment = payment;
    }

    public boolean isExit() {
        return products.getMinPrice() > payment || products.isAllSoldOut();
    }

    public int buyProduct(String name) {
        int productPrice = MIN_PRODUCT_PRICE;
        try {
            productPrice = products.buyProduct(name, payment);
            payment -= productPrice;

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return productPrice;
    }

    public String getAllChangesString() {
        return changes.toString();
    }

    public String getPayChangeString() {
        return changes.getChangesString(payment);
    }

}
