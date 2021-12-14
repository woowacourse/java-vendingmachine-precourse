package vendingmachine.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ProductTable {
    private final HashMap<String, Product> productTable = new HashMap<>();

    public void addProduct(Product newProduct) {
        productTable.put(newProduct.getName(), newProduct);
    }

    public void addProduct(String name, int price, int stock) {
        checkExists(name, false);
        productTable.put(name, new Product(name, price, stock));
    }

    public void deleteProduct(String productName) {
        checkExists(productName, true);
        productTable.remove(productName);
    }

    public int sellProduct(String productName) {
        checkSellable(productName, true);
        productTable.get(productName).sell();
        return productTable.get(productName).getPrice();
    }

    public int getPriceOfProduct(String productName) {
        checkExists(productName, true);
        return productTable.get(productName).getPrice();
    }

    public int getCheapestPrice() {
        if (productTable.size() == 0) {
            return -1;
        }
        ArrayList<Product> list = new ArrayList<>(productTable.values());
        list.sort(Comparator.naturalOrder());
        for (Product product : list) {
            if (product.isAvailable()) {
                return product.getPrice();
            }
        }
        return -1;
    }

    public boolean isThereAvailableProduct() {
        for (Product product : productTable.values()) {
            if (product.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public void clearTable() {
        productTable.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ProductTable {\n");
        for (Product product : productTable.values()) {
            sb.append("\t[");
            sb.append(product.getName());
            sb.append(",");
            sb.append(product.getPrice());
            sb.append(",");
            sb.append(product.getStock());
            sb.append("]\n");
        }
        sb.append("}");
        return sb.toString();
    }

    private void checkExists(String productName, boolean expect) {
        if (productTable.containsKey(productName) != expect) {
            if (expect) {
                throw new IllegalArgumentException("\"" + productName + "\"라는 이름의 상품이 존재하지 않습니다.");
            }
            throw new IllegalArgumentException("\"" + productName + "라는 이름의 상품이 이미 존재합니다.");
        }
    }

    private void checkSellable(String productName, boolean expect) {
        checkExists(productName, true);
        if (productTable.get(productName).isAvailable() != expect) {
            if (expect) {
                throw new IllegalArgumentException("\"" + productName + "\"은(는) 현재 구매 불가능한 상태입니다.");
            }
            throw new IllegalArgumentException("\"" + productName + "\"은(는) 구매 가능한 상태입니다.");
        }
    }
}
