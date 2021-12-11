package vendingmachine.product;

public class ProductService {
    ProductController productController = new ProductController();

    public Product makeProduct(String product){
        String[] infos = product.split(",");
        return new Product(infos[0],Integer.valueOf(infos[1]),Integer.valueOf(infos[2]));
    }
}
