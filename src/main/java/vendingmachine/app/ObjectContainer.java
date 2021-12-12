package vendingmachine.app;

import vendingmachine.model.VendingMachine;
import vendingmachine.repository.ProductRepository;
import vendingmachine.service.ProductRepositoryService;
import vendingmachine.service.VendingMachineService;

/*
프로그램 생성 시 vendingMachine, productRepository가 생성되어
싱글톤 패턴을 유지하도록 함
 */
public class ObjectContainer {
	private static final VendingMachine vendingMachine = new VendingMachine();
	private static final ProductRepository productRepository = new ProductRepository();

	public static VendingMachineService getVendingMachineService() {
		return new VendingMachineService(vendingMachine);
	}

	public static ProductRepositoryService getProductRepositoryService() {
		return new ProductRepositoryService(productRepository);
	}

	private ObjectContainer() {
	}
}

