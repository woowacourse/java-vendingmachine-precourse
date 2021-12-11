package vendingmachine.service;

import static vendingmachine.utils.Constant.*;

import java.util.List;

import vendingmachine.domain.Machine;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductRepository;
import vendingmachine.exception.CustomerLeakMoneyException;

public class ProductService {

	private final Machine machine;
	private final ProductRepository productRepository;

	public ProductService(Machine machine, ProductRepository productRepository) {
		this.machine = machine;
		this.productRepository = productRepository;
	}

	public void sellProduct(String name) {
		Product findItem = productRepository.findByName(name);
		findItem.sellProduct();
		machine.changeAmount(findItem.getPrice());
	}

	public void saveAll(String[] productArray) {
		for (int i = 0; i < productArray.length; i++) {
			String[] productData = productArray[i].substring(1, productArray[i].length() - 1).split(COMMA);
			productRepository.save(
				productData[0],
				Integer.parseInt(productData[1]),
				Integer.parseInt(productData[2])
			);
		}
	}

	public boolean checkProductIsExistedByName(String name){
		Product findItem = productRepository.findByName(name);
		if(findItem == null || !findItem.isExistedProduct()){
			return false;
		}

		if(!checkCustomerIsAvailableBuyProduct(findItem)){
			throw new CustomerLeakMoneyException();
		}
		return true;
	}

	private boolean checkCustomerIsAvailableBuyProduct(Product findItem){
		return findItem.getPrice() <= machine.getAmount();
	}

}
