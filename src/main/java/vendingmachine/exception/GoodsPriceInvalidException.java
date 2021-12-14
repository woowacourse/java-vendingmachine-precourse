package vendingmachine.exception;

import static vendingmachine.constant.ExceptionConstant.*;

public class GoodsPriceInvalidException extends IllegalArgumentException {
	public GoodsPriceInvalidException() {
		super(GOODS_PRICE_INVALID_EXCEPTION_MESSAGE);
		System.out.println(GOODS_PRICE_INVALID_EXCEPTION_MESSAGE);
	}
}
