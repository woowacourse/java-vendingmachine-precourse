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

    public int findMinPrice(){
        List<Product> products = vendingMachine.getProducts();
        return products.stream()
                .mapToInt(product -> product.getPrice())
                .min()
                .getAsInt();
    }

    public List<Product> findAll(){
       return vendingMachine.getProducts();
    }

    public List<Integer> findAllQuantity(){
        List<Product> products = vendingMachine.getProducts();
        return products.stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());
    }

    public int findChange(){
        return vendingMachine.getChange();
    }

    public List<Integer> findCoins(){
        return vendingMachine.getCoins();
    }
}
