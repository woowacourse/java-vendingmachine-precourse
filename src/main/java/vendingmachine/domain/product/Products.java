package vendingmachine.domain.product;

import java.util.ArrayList;
import java.util.List;

public class Products {

	private List<Product> productList;

	public Products(){
		productList = new ArrayList<>();
	}

	public void insert(Product product) {
		productList.add(product);
	}

	public List<Product> getProductList() {
		return productList;
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
