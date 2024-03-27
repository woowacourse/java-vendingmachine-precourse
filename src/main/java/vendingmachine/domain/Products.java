package vendingmachine.domain;

import java.util.HashSet;
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
        Set<Product> newProducts = new HashSet<>(products);
        for(Product originalProduct : products){
            if(originalProduct.getName().equals(productName)) {
                Product newProduct = originalProduct.buyOne();
                newProducts.remove(originalProduct);
                newProducts.add(newProduct);
            }
        }
        return new Products(newProducts);
    }

    public boolean contains(Product product) {
        boolean contains = false;
        for(Product originalProduct : this.products) {
            if(originalProduct.getName().equals(product.getName()) && originalProduct.getCost() == product.getCost() && originalProduct.getCount() == product.getCount()) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public int getCostByProductName(String productName) {
        for(Product product : this.products) {
            if(product.getName().equals(productName)) return product.getCost();
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 상품이다.");
    }

    public int getSmallestCost() {
        int min = Integer.MAX_VALUE;
        for(Product product : this.products) {
            int cost = product.getCost();
            if(cost<min) min = cost;
        }
        return min;
    }

    public boolean isSoldOut() {
        for(Product product : this.products) {
            if(product.getCount() > 0) return false;
        }
        return true;
    }
}
