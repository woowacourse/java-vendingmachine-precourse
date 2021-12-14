package vendingmachine.service;

import java.util.List;

import vendingmachine.dto.ProductDto;

public interface MachineService {

	void fillWithCoins(int money);

	void saveProducts(List<ProductDto> productDtos);

	void depositMoneyOfUser(int money);

	void purchaseProduct(String productName);

	void refundChanges();

	List<String> getCoinsOfMachine();

}
