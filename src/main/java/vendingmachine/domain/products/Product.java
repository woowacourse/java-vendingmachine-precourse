package vendingmachine.domain.products;

import vendingmachine.domain.Money;

public class Product {

    private final String name;
    private final Price price;
    private final Quantity quantity;

    public Product(String name, Price price, Quantity quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public boolean purchasableProduct(Money money) {
        return purchasablePrice(money) && purchasableQuantity();
    }

    private boolean purchasablePrice(Money money) {
        return price.validateMoney(money);
    }

    private boolean purchasableQuantity() {
        return quantity.isRemain();
    }

    public Product CheaperPriceProduct(Product product) {
        if (this.price.isCheaperPrice(product.price)) {
            return this;
        }
        return product;
    }

    public void purchase(Money money) {
        price.payPrice(money);
        quantity.decrease();
    }

    public boolean isPurchaseProduct(Money money) {
        return price.isPurchase(money);
    }
    public boolean isSoldOut(){
        return !quantity.isRemain();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            return this.name.equals(((Product) o).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
