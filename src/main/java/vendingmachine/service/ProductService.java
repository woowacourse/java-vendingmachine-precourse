package vendingmachine.service;

import static vendingmachine.utils.Constant.*;

import java.util.List;

import vendingmachine.domain.Machine;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductFactory;
import vendingmachine.domain.product.Products;
import vendingmachine.exception.ProductIsNotExistedException;

public class ProductService {

	private final Machine machine;
	private final Products products;
	private final ProductFactory productFactory;

	public ProductService(Machine machine, Products products, ProductFactory productFactory) {
		this.machine = machine;
		this.products = products;
		this.productFactory = productFactory;
	}

	public void sellProduct(String name) {
		Product productItem = products.getProductList()
			.stream()
			.filter(p -> p.getName().equalsIgnoreCase(name))
			.findFirst()
			.orElseThrow(ProductIsNotExistedException::new);

		productItem.sellProduct();
		machine.changeAmount(productItem.getPrice());
	}

	public List<Product> getProductList(){
		return products.getProductList();
	}

	public void save(String[] productArray) {
		for (int i = 0; i < productArray.length; i++) {
			String[] productData = productArray[i].substring(1, productArray[i].length() - 1).split(COMMA);
			products.insertProduct(
				productFactory.createProduct(
					productData[0],
					Integer.parseInt(productData[1]),
					Integer.parseInt(productData[2])));
		}
	}

}
