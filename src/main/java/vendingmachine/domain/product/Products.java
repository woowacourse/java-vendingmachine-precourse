package vendingmachine.domain.product;

import static vendingmachine.domain.Machine.*;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Machine;

public enum Products {
	PRODUCTS(MACHINE);

	private List<Product> productList;
	private Machine machine;

	Products(Machine machine){
		productList = new ArrayList<>();
		this.machine = machine;
	}

	public void insertProductToList(Product product) {
		productList.add(product);
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void buyProduct(Product product){
		product.sellProduct();
		machine.changeAmount(product.getPrice());
		// System.out.println("sell :" + name + ", rest amount "+product.getAmount());
	}

	public int getMinPriceOfProducts() {
		return productList.stream().mapToInt(p -> p.getPrice()).min().orElseThrow(NumberFormatException::new);
	}

	public boolean isProductExisted() {
		if(productList.stream().mapToInt(p -> p.getAmount()).sum() ==0){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		productList.stream()
			.forEach(k -> sb.append(k.toString()+"\n"));
		return sb.toString();
	}
}
