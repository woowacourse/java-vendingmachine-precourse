package vendingmachine.dto;

public class ProductDto {
	private final String input;

	public ProductDto(String input) {
		this.input = input;
	}

	public void convertProducts() {
		String[] products = input.split(";");
	}
}
