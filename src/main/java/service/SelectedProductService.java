package service;

import domain.PossessionAmount;
import domain.Products;
import domain.SelectedProduct;

public class SelectedProductService {
    public SelectedProduct createSelectedProduct(final String wantedProduct, final Products products){
        return SelectedProduct.create(wantedProduct, products);
    }
}
