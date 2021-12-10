package vendingmachine.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.utils.Constant.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;

class ValidatorTest extends NsTest {

	private Validator validator;
	private Products products;

	@BeforeEach
	void beforeEach(){
		validator = Validator.VALIDATOR;
		products = Products.PRODUCTS;
	}

	@Test
	void 숫자입력_포맷_예외테스트_정상(){
		String amount = "1000";
		assertEquals(validator.validateNumberFormat(amount), true);
	}

	@Test
	void 숫자입력_포맷_예외테스트_최소단위보다작음(){
		String amount = "5";
		validator.validateNumberFormat(amount);
		assertThat(output()).contains(AMOUNT_IS_NOT_RANGED_EXCEPTION_MESSAGE);
	}

	@Test
	void 숫자입력_포맷_예외테스트_입력값오류(){
		String amount = "일이사육";
		validator.validateNumberFormat(amount);
		assertThat(output()).contains(AMOUNT_NUMBER_FORMAT_EXCEPTION_MESSAGE);
	}

	@Test
	void 상품입력_포맷_예외테스트_정상(){
		String[] productInputs = {
			"[콜라,1500,20];[사이다,1000,10];[환타,800,10]",
			"[콜라1,110,1];[사이다1,1000,10]",
			"[콜라2,1500,1];;;[사이다2,20,10];[환타2,800,10]",
		};

		Arrays.stream(productInputs).forEach(s ->
			assertEquals(validator.validateProductInputFormat(s),true));
	}

	@Test
	void 상품입력_포맷_예외테스트_세미클론오류1_다른문자입력(){
		String product = "[콜라,1500,20];asdasd[사이다,1000,10];[환타,800,10]";
		validator.validateProductInputFormat(product);
		assertThat(output()).contains(PRODUCT_INPUT_SEMICOLON_EXCEPTION_MESSAGE);
	}

	@Test
	void 상품입력_포맷_예외테스트_세미클론오류2_세미클론없음(){
		String product = "[콜라,1500,20][환타,800,10]";
		validator.validateProductInputFormat(product);
		assertThat(output()).contains(PRODUCT_INPUT_SEMICOLON_EXCEPTION_MESSAGE);
	}

	@Test
	void 상품입력_포맷_예외테스트_상품내용오류1_수량1개미만(){
		String product = "[콜라,1500,0]";
		validator.validateProductInputFormat(product);
		assertThat(output()).contains(PRODUCT_INPUT_FORMAT_EXCEPTION);
	}

	@Test
	void 상품입력_포맷_예외테스트_상품내용오류2_상품금액코인최소단위미만(){
		String product = "[콜라,9,10]";
		validator.validateProductInputFormat(product);
		assertThat(output()).contains(PRODUCT_INPUT_FORMAT_EXCEPTION);
	}

	@Test
	void 상품입력_포맷_예외테스트_입력값오류0_대괄호(){
		String product = "[사이다,1000,10";
		validator.validateProductInputFormat(product);
		assertThat(output()).contains(PRODUCT_INPUT_FORMAT_EXCEPTION);
	}

	@Test
	void 상품입력_포맷_예외테스트_입력값오류1_콤마중복(){
		String product = "[사이다,,1000,10]";
		validator.validateProductInputFormat(product);
		assertThat(output()).contains(PRODUCT_INPUT_FORMAT_EXCEPTION);
	}

	@Test
	void 상품입력_포맷_예외테스트_입력값오류2_가격숫자포맷(){
		String product = "[사이다,일이삼,10]";
		validator.validateProductInputFormat(product);
		assertThat(output()).contains(PRODUCT_INPUT_FORMAT_EXCEPTION);
	}

	@Test
	void 상품입력_포맷_예외테스트_입력값오류3_수량숫자포맷(){
		String product = "[사이다,1000,삼]";
		validator.validateProductInputFormat(product);
		assertThat(output()).contains(PRODUCT_INPUT_FORMAT_EXCEPTION);
	}

	@Test
	void 상품_존재여부_예외테스트(){
		List<Product> productList = Lists.list(new Product("콜라", 1000, 10),
			new Product("사이다", 800, 10));
		productList.stream().forEach(s -> products.insertProduct(s));
		validator.validateProductExisted("콜라라라");
		assertThat(output()).contains(PRODUCT_IS_NOT_EXISTED_EXCEPTION_MESSAGE);

	}



	@Override
	protected void runMain() {

	}
}