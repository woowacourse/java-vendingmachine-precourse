package domain;

import domain.wrapper.Name;
import domain.wrapper.Price;
import domain.wrapper.Quantity;

import java.util.Objects;

import static domain.constant.ProductConstant.SPLIT_DELIMITER_COMMA;
import static util.message.ExceptionMessage.BLANK_MESSAGE;

public class Product {
    private final Name name;
    private final Price price;
    private final Quantity quantity;

    private Product(final String productDetail){
        validateBlank(productDetail);
        String[] product = splitProduct(productDetail);
        this.name = Name.create(product[0]);
        this.price = Price.create(product[1]);
        this.quantity = Quantity.create(product[2]);
    }

    public static Product create(final String productDetail){
        return new Product(productDetail);
    }

    private String[] splitProduct(final String productDetail){
        return productDetail.split(SPLIT_DELIMITER_COMMA.getValue());
    }

    private void validateBlank(final String productDetail){
        if (productDetail == null || productDetail.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "상품명, 가격, 수량"));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }

    public String getName() {
        return name.getName();
    }

    public int getPrice() {
        return price.getPrice();
    }

    public int getQuantity() {
        return quantity.getQuantity();
    }
}
