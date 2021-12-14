package vendingmachine.exception;

import static vendingmachine.constant.ExceptionConstant.*;

public class NotExistGoodsNameException extends IllegalArgumentException {
	public NotExistGoodsNameException() {
		super(NOT_EXIST_GOODS_NAME_EXCEPTION_MESSAGE);
		System.out.println(NOT_EXIST_GOODS_NAME_EXCEPTION_MESSAGE);
	}

}
