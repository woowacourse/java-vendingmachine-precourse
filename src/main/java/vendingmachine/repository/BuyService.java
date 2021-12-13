package vendingmachine.repository;

import static vendingmachine.repository.ChangeRepository.subtractChange;
import static vendingmachine.repository.ProductRepository.substractProductQuantity;

public class BuyService {
    public static void sellProduct(String name) {
        subtractChange(substractProductQuantity(name));
    }
}
