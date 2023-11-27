package dto;

import domain.wrapper.Name;

public class ProductNameDto {
    private final String productName;

    private ProductNameDto(String productName){
        this.productName = productName;
    }

    public static ProductNameDto create(String productName){
        return new ProductNameDto(productName);
    }

    public Name toEntity(){
        return Name.create(productName);
    }
}
