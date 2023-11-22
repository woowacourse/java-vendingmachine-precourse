package vendingmachine.domain;

public class Product {

    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        validatePrice(price);
        this.price = price;
        this.quantity = quantity;
    }

    private void validatePrice(int price) {
        if (price < 100) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원 이상이어야 합니다.");
        }
        if (price % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10원 단위만 가능합니다.");
        }
    }

    public void decreaseQuantity() {
        this.quantity--;
    }

    public boolean isPriceGreaterThan(int amount) {
        return price > amount;
    }

    public boolean isSoldOut() {
        return quantity == 0;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public int getPrice() {
        return price;
    }
}
