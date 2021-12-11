package vendingmachine.product;

public class ProductService {
    ProductController productController = new ProductController();

    public Product makeProduct(String product){
        return productController.makeProduct(product.split(","));
    }

}
