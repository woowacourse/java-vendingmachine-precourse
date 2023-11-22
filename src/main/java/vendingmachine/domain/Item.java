package vendingmachine.domain;

import vendingmachine.utils.ItemValidator;

import static vendingmachine.exception.ErrorMessage.CANNOT_BUY_ORDER_ITEM;

public class Item {
    private final String name;
    private final long price;
    private long quantity;

    private Item(String name, long price, long quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Item of(String name, long price, long quantity) {
        ItemValidator.validatePrice(price);

        return new Item(name, price, quantity);
    }

    public void buyItem(long priceAmount) {
        if (canBuy(priceAmount)) {
            updateQuantity();
            return;
        }
        throw new IllegalArgumentException(CANNOT_BUY_ORDER_ITEM.getMessage());
    }

    private void updateQuantity() {
        quantity--;
    }

    public boolean canBuy(long priceAmount) {
        return hasQuantity() && priceAmount >= price;
    }

    public boolean hasQuantity() {
        return quantity > 0;
    }

    public String provideName() {
        return name;
    }

    public long providePrice() {
        return price;
    }

    public boolean hasNoQuantity() {
        return quantity == 0;
    }
}
