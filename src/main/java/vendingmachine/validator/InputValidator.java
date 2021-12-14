package vendingmachine.validator;

import java.util.Optional;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.Constant;
import vendingmachine.utils.ExceptionMessage;
import static vendingmachine.utils.Constant.ZERO;

public class InputValidator {

	public void isNull(String value) {
		if (value.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessage.NULL_VALUE);
		}
	}

	// 상품 목록
	public String isRightFormat(String value) {
		if (!value.startsWith("[") || !value.endsWith("]")) {
			throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_BRACKETS);
		}
		return value.replace("[", "").replace("]", "");
	}

	public void isRightPattern(String value) {
		if (value.split(",").length != Constant.ELEMENT) {
			throw new IllegalArgumentException(ExceptionMessage.MISMATCH_FORMAT);
		}
	}

	public void isDuplicate(VendingMachine machine) {
		if (machine.getProducts().stream().distinct().count() < machine.getProducts().size()) {
			throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_PRODUCT);
		}
	}

	// 지폐
	public int validateMoney(String input) {
		int money = isPositiveNumber(input);

		isOverMoneyLimit(money);
		isPossibleMod(money);

		return money;
	}

	public void isOverMoneyLimit(int money) {
		if (money < Constant.LIMIT_PAY) {
			throw new IllegalArgumentException(ExceptionMessage.UNDER_LIMIT_PAY);
		}
	}

	public void isPossibleMod(int money) {
		if (money % Constant.UNIT_MOD != 0) {
			throw new IllegalArgumentException(ExceptionMessage.NOT_MOD);
		}
	}

	// 숫자
	public int isPositiveNumber(String value) {
		try {
			int number = Integer.parseInt(value);
			if (number <= ZERO) {
				throw new IllegalArgumentException();
			}
			return number;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ExceptionMessage.NOT_POSITIVE);
		}
	}

	// 상품 구매 시 발생 가능
	public Product isExist(String name, int money, VendingMachine machine) {
		Optional<Product> product = machine.findProduct(name);
		if (!product.isPresent()) {
			throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_PRODUCT);
		}
		isEnoughMoney(money, product.get());
		isStock(name, machine);
		return product.get();
	}
	
	public void isEnoughMoney(int money, Product product) {
		if (money < product.getPrice()) {
			throw new IllegalArgumentException(ExceptionMessage.NOT_ENOUGH_MONEY);
		}
	}

	public void isStock(String name, VendingMachine machine) {
		if (machine.findProduct(name).get().getStock()==ZERO) {
			throw new IllegalArgumentException(ExceptionMessage.SOLD_OUT_PRODUCT);
		}
	}
}