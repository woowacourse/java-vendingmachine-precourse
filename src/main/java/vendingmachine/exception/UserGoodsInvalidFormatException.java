package vendingmachine.exception;

import static vendingmachine.constant.ExceptionConstant.*;

public class UserGoodsInvalidFormatException extends IllegalArgumentException {
	public UserGoodsInvalidFormatException() {
		super(USER_GOODS_INVALID_FORMAT_EXCEPTION_MESSAGE);
		System.out.println(USER_GOODS_INVALID_FORMAT_EXCEPTION_MESSAGE);
	}
}
