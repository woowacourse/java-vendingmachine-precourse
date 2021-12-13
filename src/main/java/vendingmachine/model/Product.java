package vendingmachine.model;

public class Product {

    private final Name name;
    private final Price price;
    private final Count count;

    public Product(final String name, final int price, final int count) {
        this.name = new Name(name);
        this.price = new Price(price);
        this.count = new Count(count);
    }

    public Name getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Count getCount() {
        return count;
    }

    public int getProductCount() {
        return count.getCount();
    }

    public int getProductPrice() {
        return price.getPrice();
    }

}
