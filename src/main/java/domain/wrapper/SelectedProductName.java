package domain.wrapper;

import domain.Products;
import util.exception.NoResourceException;

import java.util.Objects;

import static util.message.ExceptionMessage.BLANK_MESSAGE;
import static util.message.ExceptionMessage.NO_RESOURCE_MESSAGE;

public class SelectedProductName {
    private final String name;

    private SelectedProductName(final String name, final Products products){
        validateBlank(name);
        this.name = name;
        validateExistence(products);
    }

    public static SelectedProductName create(final String name, final Products products){
        return new SelectedProductName(name, products);
    }

    private void validateBlank(final String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "구매할 상품명"));
        }
    }
    private void validateExistence(Products products){
        if (!products.containsProductName(name)) {
            throw new NoResourceException(String.format(NO_RESOURCE_MESSAGE.getValue(), "해당 상품"));
        }
    }

    @Override
    public boolean equals(Object diffName) {
        if (this == diffName) return true;
        if (diffName == null || getClass() != diffName.getClass()) return false;
        SelectedProductName nameInfo = (SelectedProductName) diffName;
        return Objects.equals(name, nameInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

}
