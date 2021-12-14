package vendingmachine.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.dto.ProductDto;
import vendingmachine.exception.FormatIsNotCorrectMessageException;
import vendingmachine.exception.MoneyNotMultipleOfTenMessageException;
import vendingmachine.exception.MoneyNotNumericMessageException;
import vendingmachine.exception.MoneyNotPositiveMessageException;
import vendingmachine.exception.ProductInputNotExistMessageException;
import vendingmachine.exception.ProductNameDuplicatedMessageException;
import vendingmachine.exception.QuantityNotNumericMessageException;
import vendingmachine.exception.VendingMachineException;
import vendingmachine.view.reader.Reader;

public class InputView {

	private final Reader reader;
	private final OutputView outputView;

	public InputView(Reader reader, OutputView outputView) {
		this.reader = reader;
		this.outputView = outputView;
	}

	public int requestMoneyOfMachine() {
		return getValidMoney();
	}

	private int getValidMoney() {
		String inputString = reader.readLine();
		int money = convertMoneyStringToInteger(inputString);
		validateMoney(money);
		return money;
	}

	private int convertMoneyStringToInteger(String inputString) {
		try {
			return Integer.parseInt(inputString);
		} catch (NumberFormatException ex) {
			throw new MoneyNotNumericMessageException();
		}
	}

	private void validateMoney(int balance) {
		validateMoneyIsPositive(balance);
		validateMoneyIsMultipleOfTen(balance);
	}

	private void validateMoneyIsPositive(int balance) {
		if (isNumberNotPositive(balance)) {
			throw new MoneyNotPositiveMessageException();
		}
	}

	private boolean isNumberNotPositive(int number) {
		return (number <= 0);
	}

	private void validateMoneyIsMultipleOfTen(int balance) {
		if (isNumberNotMultipleOfTen(balance)) {
			throw new MoneyNotMultipleOfTenMessageException();
		}
	}

	private boolean isNumberNotMultipleOfTen(int number) {
		return (number % 10 != 0);
	}

	public int requestMoneyOfUser() {
		return getValidMoney();
	}

	public String requestProductName() {
		return reader.readLine();
	}

	public List<ProductDto> requestProductDtos() {
		return getValidProductDtos();
	}

	private List<ProductDto> getValidProductDtos() {
		String inputString = reader.readLine();
		List<ProductDto> productDtos = new ArrayList<>();
		Arrays.stream((inputString + " ").split(";")).map(String::trim)
			.forEach(information -> {
				ProductDto productDto = getValidProductDto(information);
				productDtos.add(productDto);
			});
		validateExistProductDto(productDtos);
		validateProductDtoDuplicated(productDtos);
		return productDtos;
	}

	private ProductDto getValidProductDto(String information) {
		validateProductInformationString(information);
		information = information.substring(1, information.length() - 1);
		List<String> datas = Arrays.stream((information + " ").split(",")).map(String::trim).collect(Collectors.toList());
		return convertInformationStringToProductDto(datas);
	}

	private void validateProductInformationString(String information) {
		if (information.equals("")) {
			throw new VendingMachineException("상품 정보가 비어있습니다.");
		}
		if (information.charAt(0) != '[') {
			throw new FormatIsNotCorrectMessageException();
		}
		if (information.charAt(information.length() - 1) != ']') {
			throw new FormatIsNotCorrectMessageException();
		}
	}

	private ProductDto convertInformationStringToProductDto(List<String> datas) {
		if (datas.size() != 3) {
			throw new FormatIsNotCorrectMessageException();
		}
		String productName = datas.get(0);
		int productPrice = convertMoneyStringToInteger(datas.get(1));
		int productQuantity = convertQuantityStringToInteger(datas.get(2));
		return new ProductDto(productName, productPrice, productQuantity);
	}

	private int convertQuantityStringToInteger(String inputString) {
		try {
			return Integer.parseInt(inputString);
		} catch (NumberFormatException ex) {
			throw new QuantityNotNumericMessageException();
		}
	}

	private void validateExistProductDto(List<ProductDto> productDtos) {
		if (productDtos.size() == 0) {
			throw new ProductInputNotExistMessageException();
		}
	}

	private void validateProductDtoDuplicated(List<ProductDto> productDtos) {
		List<String> productNames = productDtos.stream().map(ProductDto::getName).collect(Collectors.toList());
		if (productNames.stream().anyMatch(name -> Collections.frequency(productNames, name) > 1)) {
			throw new ProductNameDuplicatedMessageException();
		}
	}

}
