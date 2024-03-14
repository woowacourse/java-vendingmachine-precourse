package vendingmachine.domain;

import java.util.Set;

public class Products {
    private final Set<Product> products;

    public Products(Set<Product> products) {
        this.products = products;
    }

    public Set<Product> getProducts() {
        return this.products;
    }

    public Products buyOne(String productName) {
        Set<Product> newProducts = products;
        for(Product originalProduct : newProducts){
            if(originalProduct.getName().equals(productName)) {
                Product newProduct = originalProduct.buyOne();
                newProducts.remove(originalProduct);
                newProducts.add(newProduct);
            }

        }
        return new Products(newProducts);
    }
}
