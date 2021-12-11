package vendingmachine.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
	private String name;
	private int price;
	private int quantity;
}
