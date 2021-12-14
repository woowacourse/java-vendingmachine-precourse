package vendingmachine.view.input.validator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.dto.ProductDto;
import vendingmachine.exception.ProductInputNotExistMessageException;
import vendingmachine.exception.ProductNameDuplicatedMessageException;

public class ProductDtoValidator {

	private static final ProductDtoValidator instance = new ProductDtoValidator();

	public static void validate(List<ProductDto> productDtos) {
		instance.validateInformationEmpty(productDtos);
		instance.validateInformationDuplicated(productDtos);
	}

	private void validateInformationEmpty(List<ProductDto> productDtos) {
		if (productDtos.size() == 0) {
			throw new ProductInputNotExistMessageException();
		}
	}

	private void validateInformationDuplicated(List<ProductDto> productDtos) {
		List<String> productNames = productDtos.stream().map(ProductDto::getName).collect(Collectors.toList());
		if (productNames.stream().anyMatch(name -> this.isDuplicated(productNames, name))) {
			throw new ProductNameDuplicatedMessageException();
		}
	}

	private boolean isDuplicated(List<String> productNames, String productName) {
		return (Collections.frequency(productNames, productName) > 1);
	}

}
