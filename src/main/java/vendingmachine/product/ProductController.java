package vendingmachine.product;

import vendingmachine.exception.ProductValidator;

public class ProductController {
    private final ProductService productService = new ProductService();

    public Product makeProduct(String product){
        return productService.makeProduct(product);
    }
}
