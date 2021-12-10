package vendingmachine.service;


import vendingmachine.domain.Machine;
import vendingmachine.domain.product.Products;

public class MachineService {

	private final Machine machine;
	private final Products products;

	public MachineService(Machine machine, Products products) {
		this.machine = machine;
		this.products = products;
	}

	public void save(int amount) {
		machine.save(amount);
	}

	public int getAmount(){
		return machine.getAmount();
	}

	public boolean checkMachineIsWorking() {
		if (machine.isAmountLessThanProductMinPrice(products.getMinPriceOfProducts()) || !products.isProductExisted()) {
			return true;
		}
		return false;
	}
}
