package vendingmachine.domain;

public class Product {

    private final String merchandiseName;
    private final int price;
    private final int numberOfProducts;

    public Product(final String merchandiseName, final int price, final int numberOfProducts) {
        this.merchandiseName = merchandiseName;
        this.price = price;
        this.numberOfProducts = numberOfProducts;
    }

}
