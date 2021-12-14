package vendingmachine.utils;

public class Message {
	public static final String REQUEST_MESSAGE_THERE_IS_NO_COIN = "해당하는 값이 없습니다.";
	public static final String REQUEST_MESSAGE_THERE_IS_NO_PRODUCT = "해당 상품은 존재하지 않습니다.";
	public static final String REQUEST_MESSAGE_INPUT_ONLY_DIGIT = "금액은 숫자만 입력해주세요.";
	public static final String REQUEST_MESSAGE_IS_OR_GREATER_THAN_ONE =
		"정상 범위(" + Constant.CONSTANT_ONE + "~" + Constant.CONSTANT_END_RANGE_OF_INTEGER
			+ ")가 아닙니다";
	public static final String REQUEST_MESSAGE_TEN_UNIT = "10원 단위로 입력해주세요";
	public static final String REQUEST_MESSAGE_NO_SPACE = "빈칸 입력은 허용하지 않는다.";
	public static final String REQUEST_MESSAGE_NO_PRODUCT_NAME = "상품명이 누락되었습니다.";
	public static final String REQUEST_MESSAGE_INVALID_PATTERN = "패턴에 맞지 않는 입력입니다.";
	public static final String REQUEST_MESSAGE_INVALID_AMOUNT = "상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.";
	public static final String REQUEST_MESSAGE_DUPLICATE_NAME = "같은 상품이 중복 입력되었습니다.";
	public static final String REQUEST_MESSAGE_MORE_THAN_ONE = "상품 갯수는 1개이상이어야한다.";
	public static final String REQUEST_MESSAGE_THIS_IS_ZERO_COUNT = "해당 상품은 현재 0개 입니다.";
	public static final String REQUEST_MESSAGE_INVALID_MONEY = "해당 상품의 가격이 보유중인 금액보다 비쌉니다.";
	public static final String REQUEST_MESSAGE_INVALID_RANGE =
		Constant.CONSTANT_ONE + "~" + Constant.CONSTANT_END_RANGE_OF_INTEGER + " 글자 범위 내에서 입력하세요.";
}
