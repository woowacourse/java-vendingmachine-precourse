package vendingmachine.service;


import vendingmachine.domain.Machine;
import vendingmachine.domain.product.ProductRepository;

public class MachineService {

	private final Machine machine;
	private final ProductRepository productRepository;

	public MachineService(Machine machine, ProductRepository productRepository) {
		this.machine = machine;
		this.productRepository = productRepository;
	}

	public void saveCustomerAmount(int amount) {
		machine.save(amount);
	}

	public int getCustomerAmount() {
		return machine.getAmount();
	}

	public boolean checkIsMachineAvailable() {
		int minOfProductsPrice = productRepository.findOneByPriceDesc();
		int sumOfProductsAmount = productRepository.getSumOfProductsAmount();

		if (machine.isAmountLessThanMinOfProductsPrice(minOfProductsPrice) || sumOfProductsAmount == 0) {
			return false;
		}
		return true;
	}
}
