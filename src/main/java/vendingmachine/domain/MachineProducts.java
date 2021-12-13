package vendingmachine.domain;

import static vendingmachine.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.service.ProductService;

public class MachineProducts {
	List<Product> products = new ArrayList<>();

	public MachineProducts(String inputLine) {
		products = makeProducts(inputLine);
	}

	private List<Product> makeProducts(String inputLine) {
		List<String> strings = ProductService.splitBySemicolon(inputLine);
		return strings.stream()
			.map(string -> Product.makeProduct(string))
			.collect(Collectors.toList());
	}
}
