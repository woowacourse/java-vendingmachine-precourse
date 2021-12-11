package vendingmachine.product;

public class ProductController {
    public Product makeProduct(String[] infos){
        return new Product(infos[0],Integer.valueOf(infos[1]),Integer.valueOf(infos[2]));
    }
}
