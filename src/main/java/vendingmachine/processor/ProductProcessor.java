package vendingmachine.processor;

import java.util.List;

import vendingmachine.data.VendingMachineData;
import vendingmachine.exception.ProductNotFoundException;
import vendingmachine.exception.ProductSoldOutException;
import vendingmachine.type.Product;

public class ProductProcessor {

	private List<Product> productList;

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public int sellProduct(String productName) {
		Product product = findProduct(productName);
		popProduct(product);
		return product.getPrice();
	}

	private Product findProduct(String productName) {
		Product result = productList.stream()
			.filter(product -> productName.equals(product.getName()))
			.findFirst()
			.orElseThrow(() -> new ProductNotFoundException(VendingMachineData.PRODUCT_NOT_FOUND_ERROR));
		return result;
	}

	private void popProduct(Product product) {
		if(product.isSoldOut()) {
			throw new ProductSoldOutException(VendingMachineData.PRODUCT_SOLDOUT_ERROR);
		}
		product.sell();
	}

}
