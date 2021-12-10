package vendingmachine.repository;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.Message;

import java.util.List;
import java.util.stream.Collectors;


public class VendingMachineRepository {
    private VendingMachine vendingMachine;

    public VendingMachineRepository(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public Product findByName(String name){
        List<Product> products = vendingMachine.getProducts();
        Product findProduct = products.stream()
                .filter(product -> name.equals(product.getName()))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException(Message.ERROR + Message.IS_NOT_FOUNDED_PRODUCT));
        return findProduct;
    }
}
