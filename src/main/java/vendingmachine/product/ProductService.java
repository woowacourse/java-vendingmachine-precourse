package vendingmachine.product;

public class ProductService {


    public Product makeProduct(String product){
        String[] infos = product.substring(1,product.length()-1).split(",");
        return new Product(infos[0],Integer.valueOf(infos[1]),Integer.valueOf(infos[2]));
    }
}
