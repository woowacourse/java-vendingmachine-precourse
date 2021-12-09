package vendingmachine.validation;

import vendingmachine.exception.ErrorMessage;

public class Validation {

	// 금액이 문자열이 아닌지 확인
	public static void validateCostIsNumber(String cost){
		for(char c: cost.toCharArray()){
			if(!Character.isDigit(c)){
				throw new IllegalArgumentException(ErrorMessage.PRICE_IS_NOT_NUMBER_ERROR.getErrorMessage());
			}
		}
	}

	// 금액이 빈 값인지 확인
	public static void validateNull(String cost){
		if(cost.replaceAll(" ","").length()==0){
			throw new IllegalArgumentException(ErrorMessage.PRICE_IS_BLANK_ERROR.getErrorMessage());
		}
	}
}
