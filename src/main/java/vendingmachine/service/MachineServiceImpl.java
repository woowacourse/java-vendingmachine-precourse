package vendingmachine.service;

import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.domain.machine.Machine;
import vendingmachine.domain.machine.product.Product;
import vendingmachine.domain.user.User;
import vendingmachine.dto.ProductDto;

public class MachineServiceImpl implements MachineService {

	private Machine machine = new Machine();
	private User user = new User(machine);

	@Override
	public void fillWithCoins(int balance) {

	}

	@Override
	public void saveProducts(List<ProductDto> productDtos) {
		List<Product> products = productDtos.stream().map(ProductDto::toEntity).collect(Collectors.toList());
		products.forEach(machine::saveProduct);
	}

	@Override
	public void purchaseProduct(String productName) {
		user.purchase(productName);
	}

	@Override
	public void refundChanges() {

	}

}
