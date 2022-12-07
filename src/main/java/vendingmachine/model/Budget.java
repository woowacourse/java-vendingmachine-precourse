package vendingmachine.model;

public class Budget {

    private int budget;

    private Budget(int budget) {
        this.budget = budget;
    }

    public static Budget from(int budget) {
        return new Budget(budget);
    }

    public void buyProduct(String productName, Products products) {
        Product product = products.findProduct(productName);
        System.out.println(product);
    }
}
