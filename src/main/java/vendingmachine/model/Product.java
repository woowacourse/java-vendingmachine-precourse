package vendingmachine.model;

import vendingmachine.utils.ExceptionMessages;

public class Product {

    private final Name name;
    private final Price price;
    private final Count count;

    public Product(final String name, final int price, final int count) {
        validateProduct(count);
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

    public String getProductName(){
        return name.getName();
    }

    public int getProductCount() {
        return count.getCount();
    }

    public int getProductPrice() {
        return price.getPrice();
    }

    protected void validateProduct(final int count) {
        if(count < 0){
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_COUNT_LESS_THAN_ZERO.getErrorMessage());
        }
    }

}
