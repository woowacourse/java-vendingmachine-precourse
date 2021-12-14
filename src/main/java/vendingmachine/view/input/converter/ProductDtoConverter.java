package vendingmachine.view.input.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.machine.product.ProductInformationCount;
import vendingmachine.dto.ProductDto;
import vendingmachine.exception.FormatIsNotCorrectMessageException;
import vendingmachine.view.input.Delimiter;

public class ProductDtoConverter {

	private static final ProductDtoConverter instance = new ProductDtoConverter();

	private String appendSpaceBeforeSplit(String targetString) {
		return Delimiter.appendSpaceBehind(targetString);
	}

	public static List<ProductDto> convert(String inputString) {
		List<String> productInformations = instance.splitInformationByProduct(inputString);
		return productInformations.stream().map(instance::convertToProductDto).collect(Collectors.toList());
	}

	private List<String> splitInformationByProduct(String inputString) {
		inputString = instance.appendSpaceBeforeSplit(inputString);
		return Arrays.stream(Delimiter.splitWithSemiColon(inputString))
			.map(String::trim).collect(Collectors.toList());
	}

	public ProductDto convertToProductDto(String information) {
		checkInformationExist(information);
		List<String> datas = instance.splitInformationInDetail(information);
		checkDataCount(datas);

		String productName = datas.get(0);
		int productPrice = MoneyConverter.convert(datas.get(1));
		int productQuantity = QuantityConverter.convert(datas.get(2));

		return new ProductDto(productName, productPrice, productQuantity);
	}

	private void checkInformationExist(String information) {
		if (Delimiter.isEmpty(information)) {
			throw new FormatIsNotCorrectMessageException();
		}
	}

	private List<String> splitInformationInDetail(String information) {
		checkInformationEnclosedInBracket(information);
		information = instance.removeBracket(information);
		information = instance.appendSpaceBeforeSplit(information);
		return Arrays.stream(Delimiter.splitWithComma(information))
			.map(String::trim).collect(Collectors.toList());
	}

	private void checkInformationEnclosedInBracket(String information) {
		if (Delimiter.isNotEnclosedInSquareBracket(information)) {
			throw new FormatIsNotCorrectMessageException();
		}
	}

	private String removeBracket(String information) {
		return information.substring(1, information.length() - 1);
	}

	private void checkDataCount(List<String> datas) {
		if (ProductInformationCount.isNotEquals(datas.size())) {
			throw new FormatIsNotCorrectMessageException();
		}
	}

}
