package vendingmachine.validation;

import vendingmachine.exception.ErrorMessage;

public class Validation {

	// 금액이 자연수인지 확인
	public static void validateCostIsNaturalNumber(String cost) {
		for (char c : cost.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException(ErrorMessage.COST_IS_NOT_NUMBER_ERROR.getErrorMessage());
			}
		}

		if (Integer.parseInt(cost) <= 0) {
			throw new IllegalArgumentException(ErrorMessage.COST_IS_NOT_NUMBER_ERROR.getErrorMessage());
		}
	}

	// 금액이 빈 값인지 확인
	public static void validateNull(String cost){
		if(cost.replaceAll(" ","").length()==0){
			throw new IllegalArgumentException(ErrorMessage.COST_IS_BLANK_ERROR.getErrorMessage());
		}
	}

	// 금액이 10으로 나누어 떨어지지 않는 경우
	public static void validateDivideTen(int cost){
		if(cost%10!=0){
			throw new IllegalArgumentException(ErrorMessage.COST_IS_NOT_DIVIDE_TEN.getErrorMessage());
		}
	}

	// 상품이 빈 값으로 들어오는 경우

	// 상품이 하나도 들어오지 않는 경우

	// 상품 가격이 100 이상 자연수지 않는 경우

	// 상품명이 중복되어 들어오는 경우

	// 상품 수량이 자연수가 아닐 경우

	// 구매할 상품명이 목록에 없을 경우

}
