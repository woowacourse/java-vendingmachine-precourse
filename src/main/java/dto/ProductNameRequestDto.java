package dto;

public class ProductNameRequestDto {
    private final String productName;

    public ProductNameRequestDto(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
