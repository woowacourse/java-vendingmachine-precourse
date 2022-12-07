package vendingmachine.model;

public class Budget {

    private int budget;

    private Budget(int budget) {
        this.budget = budget;
    }

    public static Budget from(int budget) {
        return new Budget(budget);
    }

    public void buy(Product product) {
        budget -= product.getProductPrice();
    }

    public boolean isAffordable(Product purchaseProduct) {
        return purchaseProduct.isAffordable(budget);
    }
}
