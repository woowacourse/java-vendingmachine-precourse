package vendingmachine.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.ErrorConst;

class ValidatorTest {
	@DisplayName("투입금액 유효성 검사")
	@Nested
	class ValidateMoney {
		@DisplayName("성공")
		@Test
		public void successValidateMoney() throws Exception {
			//given
			int money = 5000;
			//then
			assertDoesNotThrow(() -> Validator.validateMoney(money));
		}

		@DisplayName("실패 : 음수가 들어온 경우")
		@Test
		public void failMinusMoney() throws Exception {
			//given
			int money = -3000;
			//when
			IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateMoney(money));
			//then
			assertEquals(e.getMessage(), ErrorConst.MONEY_IS_NOT_MINUS);
		}

		@DisplayName("실패 : 10으로 나누어 떨어지지 않는 경우")
		@Test
		public void failMoneyNotDividedTen() throws Exception {
			//given
			int money = 403;
			//when
			IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateMoney(money));
			//then
			assertEquals(e.getMessage(), ErrorConst.MONEY_IS_DIVIDED_BY_TEN);
		}
	}

	@DisplayName("상품명 유효성 검사")
	@Nested
	class ValidateItemName {
		@DisplayName("성공")
		@Test
		public void successValidateItemName() throws Exception {
			//given
			String itemName = "콜라";
			//then
			assertDoesNotThrow(() -> Validator.validateItemName(itemName));
		}

		@DisplayName("실패 : 상품명이 공백인경우")
		@Test
		public void failWhiteSpace() throws Exception {
			//given
			String itemName = "   ";
			//when
			IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateItemName(itemName));
			//then
			assertEquals(e.getMessage(), ErrorConst.ITEM_NAME_IS_NOT_WHITESPACE);
		}
	}

	@DisplayName("상품가격 유효성 검사")
	@Nested
	class ValidatePrice {
		@DisplayName("성공")
		@Test
		public void successValidatePrice() throws Exception {
			//given
			int price = 1500;
			//then
			assertDoesNotThrow(() -> Validator.validatePrice(price));
		}

		@DisplayName("실패 : 100원 이하의 가격을 입력한 경우")
		@Test
		public void failUnder100() throws Exception {
			//given
			int price = 50;
			//when
			IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> Validator.validatePrice(price));
			//then
			assertEquals(e.getMessage(), ErrorConst.ITEM_PRICE_OVER_ONE_HUNDRED);
		}

		@DisplayName("실패 : 10으로 나누어 떨어지지 않는 경우")
		@Test
		public void failNotDividedByTen() throws Exception {
			//given
			int money = 403;
			//when
			IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> Validator.validatePrice(money));
			//then
			assertEquals(e.getMessage(), ErrorConst.MONEY_IS_DIVIDED_BY_TEN);
		}
	}

	@DisplayName("상품등록 정규식 통과")
	@Nested
	class ValidateMatcher {
		@DisplayName("성공")
		@Test
		public void successValidateMatcher() throws Exception {
			//given
			String testText = "[콜라,1500,10]";
			//when
			Pattern pattern = ItemRegPattern.getPattern();
			Matcher m = pattern.matcher(testText);
			//then
			assertDoesNotThrow(() -> Validator.validateMatcher(m));
		}

		@DisplayName("실패 : 대괄호 존재 X")
		@Test
		public void failNotSquareBrackets() throws Exception {
			//given
			String testText = "콜라,1500,10";
			//when
			Pattern pattern = ItemRegPattern.getPattern();
			Matcher m = pattern.matcher(testText);
			//then
			IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateMatcher(m));
			assertEquals(e.getMessage(), ErrorConst.ITEM_OUT_OF_FORMAT);
		}

		@DisplayName("실패 : 콤마가 여러개인 경우")
		@Test
		public void failManyComma() throws Exception {
			//given
			String testText = "[콜라,,1500,10]";
			//when
			Pattern pattern = ItemRegPattern.getPattern();
			Matcher m = pattern.matcher(testText);
			//then
			IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateMatcher(m));
			assertEquals(e.getMessage(), ErrorConst.ITEM_OUT_OF_FORMAT);
		}

		@DisplayName("실패 : 가격, 개수가 숫자가 아닌 경우")
		@Test
		public void failPriceAndNumIsNotNumber() throws Exception {
			//given
			String[] testArr = {
				"[콜라,abc,10]",
				"[콜라,10,abc]"
			};
			//then
			Arrays.stream(testArr).forEach(
				testText -> {
					Pattern pattern = ItemRegPattern.getPattern();
					Matcher m = pattern.matcher(testText);
					IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
						() -> Validator.validateMatcher(m));
					assertEquals(e.getMessage(), ErrorConst.ITEM_OUT_OF_FORMAT);
				}
			);
		}

		@DisplayName("실패 : ;로 스플릿되지 않을 경우")
		@Test
		public void failUndefinedSeparator() throws Exception {
			//given
			String testText = "[콜라,100,10],[사이다,1000,10]";
			//when
			Pattern pattern = ItemRegPattern.getPattern();
			Matcher m = pattern.matcher(testText);
			//then
			IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateMatcher(m));
			assertEquals(e.getMessage(), ErrorConst.ITEM_OUT_OF_FORMAT);
		}
	}

}