package vendingmachine.service;

import vendingmachine.model.Products;
import vendingmachine.model.VendingMachine;

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

    public void saveProducts(String inputProducts) {
        Products products = new Products(inputProducts);
        vendingMachine.setProducts(products);
    }

    public void saveUserInsertAmount(int userAmount) {
        vendingMachine.setUserInsertAmount(userAmount);
    }
}
