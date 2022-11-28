package dto;

import java.util.List;

public class ProductsRequestDto {
    List<String> products;

    public ProductsRequestDto(List<String> products) {
        this.products = products;
    }

    public List<String> getProducts() {
        return products;
    }
}
