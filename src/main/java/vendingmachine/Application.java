package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.repository.ProductRepository;
import vendingmachine.service.VendingMachineService;

public class Application {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        VendingMachineService vendingMachineService = new VendingMachineService(productRepository);
        VendingMachineController vendingMachineController = new VendingMachineController(vendingMachineService);
        vendingMachineController.start();
    }
}
