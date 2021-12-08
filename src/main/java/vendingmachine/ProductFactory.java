package vendingmachine;


import static vendingmachine.Machine.*;

import java.util.HashMap;
import java.util.Map;

public enum ProductFactory {
	PRODUCT_FACTORY;
	private static final Map<String, Product> PRODUCT_INSTANCE = new HashMap<>();
	private static int minPrice = Integer.MAX_VALUE;
	public static Product createProduct(String name, int price, int amount){
		Product product = PRODUCT_INSTANCE.get(name);

		if(product==null){
			product = new Product(name, price, amount);
			PRODUCT_INSTANCE.put(name, product);
			System.out.println("new product :" + name);
			minPrice = Math.min(minPrice, price);
		}

		return product;
	}

	public static boolean isProductExisted(String name){
		if(PRODUCT_INSTANCE.containsKey(name)){
			if(PRODUCT_INSTANCE.get(name).getAmount()>0){
				return true;
			}
		}
		return false;
	}

	public static void buyProduct(String name){
		Product product = PRODUCT_INSTANCE.get(name);
		product.sellProduct();
		MACHINE.changeMachineAmount(product.getPrice());
		System.out.println("sell :" + name + ", rest amount "+product.getAmount());
	}

	public static int getProductMinPrice(){
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
