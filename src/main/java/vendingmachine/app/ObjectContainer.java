package vendingmachine.app;

import vendingmachine.model.VendingMachine;
import vendingmachine.repository.ProductRepository;
import vendingmachine.service.ProductRepositoryService;
import vendingmachine.service.VendingMachineService;

public class ObjectContainer {
	private static final VendingMachine vendingMachine = new VendingMachine();
	private static final ProductRepository productRepository = new ProductRepository();

	public static VendingMachineService getVendingMachineService() {
		return new VendingMachineService(vendingMachine);
	}

	public static ProductRepositoryService getProductRepositoryService() {
		return new ProductRepositoryService(productRepository);
	}
}

