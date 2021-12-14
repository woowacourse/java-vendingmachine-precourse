package vendingmachine.service;

import java.util.List;

import vendingmachine.dto.ProductDto;

public interface MachineService {

	void fillWithCoins(int balance);

	void saveProducts(List<ProductDto> productDtos);

	void purchaseProduct(String productName);

	void refundChanges();

	List<String> getCoinsOfMachine();

}
