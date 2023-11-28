package repository;

import domain.Product;
import domain.Products;
import domain.wrapper.Name;
import util.exception.DuplicateException;
import util.exception.NoResourceException;

import static util.message.ExceptionMessage.DUPLICATE_MESSAGE;
import static util.message.ExceptionMessage.NO_RESOURCE_MESSAGE;

public class ProductsRepository {

    private static final ProductsRepository instance = new ProductsRepository();
    private Products products;

    private ProductsRepository(){

    }

    //다음 거에 적용할 부분!
    public static ProductsRepository getInstance(){
        return instance;
    }

    public Products findAll() {
        return products;
    }

    public Products createProducts(final String productsInfo){
        this.products = new Products(productsInfo);
        return products;
    }
    public void updateByItemName(Name name, Product product) {
        Product originalItem = findByProductName(name);
        int itemIndex = products.getProducts().indexOf(originalItem);
        products.getProducts().set(itemIndex, product);
    }

    public Product findByProductName(Name name) {
        return products.getProducts().stream()
                .filter(product -> product.getName().equals(name.getName()))
                .findFirst()
                .orElseThrow(() ->
                        new NoResourceException(String.format(NO_RESOURCE_MESSAGE.getValue(), "해당 상품")));
    }

}
