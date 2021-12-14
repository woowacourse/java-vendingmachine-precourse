package vendingmachine.exception;

import static vendingmachine.constant.ExceptionConstant.*;

public class GoodsCountInvalidException extends IllegalArgumentException {
	public GoodsCountInvalidException() {
		super(GOODS_COUNT_INVALID_EXCEPTION_MESSAGE);
		System.out.println(GOODS_COUNT_INVALID_EXCEPTION_MESSAGE);
	}
}
