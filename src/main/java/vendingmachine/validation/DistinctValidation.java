package vendingmachine.validation;

import java.util.HashSet;
import java.util.List;

import vendingmachine.domain.Product;

public class DistinctValidation implements Validation<List<Product>> {

	private static final String FORMAT = "%s 은 중복될 수 없습니다.";

	@Override
	public void validate(List<Product> target, String name) throws IllegalArgumentException {
		if (new HashSet<>(target).size() != target.size()) {
			throw new IllegalArgumentException(String.format(FORMAT, name));
		}
	}
}
