package domain;

import domain.wrapper.PaymentAmount;
import domain.wrapper.SelectedProductName;
import util.exception.NoResourceException;

import static util.message.ExceptionMessage.BLANK_MESSAGE;
import static util.message.ExceptionMessage.NO_RESOURCE_MESSAGE;

public class SelectedProduct {
    private final SelectedProductName selectedProduct;
    private SelectedProduct(final String selectedProduct, final Products products){
        this.selectedProduct = SelectedProductName.create(selectedProduct, products);
    }

    public static SelectedProduct create(final String selectedProduct, final Products products){
        return new SelectedProduct(selectedProduct, products);
    }
}
