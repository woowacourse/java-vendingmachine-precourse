package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {
    private final List<Product> products = new ArrayList<>();

    public void registerProducts(String input) {
        String[] products = input
                .replaceAll("[]\\[]", "")
                .split(";");

        Arrays.stream(products)
                .map(s -> s.split(","))
                .map(s -> new Product(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2])))
                .forEach(this.products::add);
    }
}
