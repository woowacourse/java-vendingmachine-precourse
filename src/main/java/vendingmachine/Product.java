package vendingmachine;

public class Product {
    private final String productName;
    private final int productPrice;
    private final int productCount;

    public Product(String productName, int productPrice, int productCount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    //상품 개수 계산
    public Product calculateProductCount(Product product) {
        return new Product(product.productName, product.productPrice, product.productCount - 1);
    }
}
