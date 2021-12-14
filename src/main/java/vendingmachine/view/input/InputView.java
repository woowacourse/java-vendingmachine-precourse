package vendingmachine.view.input;

import java.util.List;

import vendingmachine.dto.ProductDto;
import vendingmachine.view.OutputView;
import vendingmachine.view.input.converter.MoneyConverter;
import vendingmachine.view.input.converter.ProductDtoConverter;
import vendingmachine.view.input.validator.ProductDtoValidator;
import vendingmachine.view.input.validator.MoneyValidator;
import vendingmachine.view.reader.Reader;

public class InputView {

	private final Reader reader;
	private final OutputView outputView;

	public InputView(Reader reader, OutputView outputView) {
		this.reader = reader;
		this.outputView = outputView;
	}

	public int requestMoneyOfMachine() {
		String inputString = reader.readLine();
		return convertToValidMoney(inputString);
	}

	public int requestMoneyOfUser() {
		String inputString = reader.readLine();
		return convertToValidMoney(inputString);
	}

	private int convertToValidMoney(String inputString) {
		int money = MoneyConverter.convert(inputString);
		MoneyValidator.validate(money);
		return money;
	}

	public String requestProductName() {
		return reader.readLine();
	}

	public List<ProductDto> requestProductDtos() {
		String inputString = reader.readLine();
		return convertToValidProductDtos(inputString);
	}

	private List<ProductDto> convertToValidProductDtos(String inputString) {
		List<ProductDto> productDtos = ProductDtoConverter.convert(inputString);
		ProductDtoValidator.validate(productDtos);
		return productDtos;
	}

}
