package vendingmachine.app;

import vendingmachine.model.ProductRepository;
import vendingmachine.model.VendingMachine;

public class ObjectContainer {
	public final static VendingMachine vendingMachine = new VendingMachine();
	public final static ProductRepository productRepository = new ProductRepository();
}

