package service;

import domain.Products;

public class ProductsService {
    public Products createProducts(final String productsInfo){
        return new Products(productsInfo);
    }
}
