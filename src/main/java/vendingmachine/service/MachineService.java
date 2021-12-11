package vendingmachine.service;

import vendingmachine.model.Products;
import vendingmachine.model.VendingMachine;

import java.util.List;

public class MachineService {
    private final VendingMachine vendingMachine;

    public MachineService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void buyProduct(String productName) {
        vendingMachine.checkProductQuantity(productName);
        vendingMachine.popProduct(productName);
    }

    public void saveAmount(int amount) {
        vendingMachine.setInitialAmount(amount);
    }

    public void saveProducts(List<List<String>> productList) {
        Products products = new Products(productList);
        vendingMachine.setProducts(products);
    }

    public void saveUserInsertAmount(int userAmount) {
        vendingMachine.setUserInsertAmount(userAmount);
    }
}
