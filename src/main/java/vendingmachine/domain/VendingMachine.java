package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private final Changes changes;
    private Map<Product, Integer> products = new HashMap<>();

    public VendingMachine(int seedMoney) {
        changes = new Changes(seedMoney);
    }

    public Changes getChanges() {
        return changes;
    }

    public void addProduct(Product product, int quantity) {
        this.products.put(product, quantity);
    }
}
