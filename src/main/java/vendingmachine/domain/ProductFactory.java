package vendingmachine.domain;


import static vendingmachine.domain.Machine.*;

import java.util.HashMap;
import java.util.Map;

public enum ProductFactory {
	PRODUCT_FACTORY;

	private final Map<String, Product> PRODUCT_INSTANCE = new HashMap<>();
	private int minPrice = Integer.MAX_VALUE;

	public Product createProduct(String name, int price, int amount){
		Product product = PRODUCT_INSTANCE.get(name);

		if(product==null){
			product = new Product(name, price, amount);
			PRODUCT_INSTANCE.put(name, product);
			// System.out.println("new product :" + name);
			minPrice = Math.min(minPrice, price);
		}

		return product;
	}

	public boolean isProductExisted(String name){
		if(PRODUCT_INSTANCE.containsKey(name)){
			if(PRODUCT_INSTANCE.get(name).getAmount()>0){
				return true;
			}
		}
		return false;
	}

	public void buyProduct(String name){
		Product product = PRODUCT_INSTANCE.get(name);
		product.sellProduct();
		MACHINE.changeAmount(product.getPrice());
		// System.out.println("sell :" + name + ", rest amount "+product.getAmount());
	}

	public int getProductMinPrice(){
		return minPrice;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		PRODUCT_INSTANCE.keySet().stream()
			.map(k -> PRODUCT_INSTANCE.get(k))
			.forEach(k -> sb.append(k.toString()+"\n"));
		return sb.toString();
	}
}
