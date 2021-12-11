package vendingmachine.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.utils.Constant.*;

import java.util.Arrays;

import javax.crypto.Mac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.Machine;
import vendingmachine.domain.product.ProductFactory;
import vendingmachine.domain.product.ProductRepository;
import vendingmachine.domain.product.Products;
import vendingmachine.service.ProductService;

class ValidatorTest extends NsTest {

	private Validator validator;
	private ProductFactory productFactory;
	private Products products;
	private ProductRepository productRepository;
	private ProductService productService;
	private Machine machine;


	@BeforeEach
	void beforeEach(){
		this.validator = Validator.VALIDATOR;
		this.productFactory = new ProductFactory();
		this.products = new Products();
		this.machine = new Machine();
		machine.save(5000);
		this.productRepository = new ProductRepository(products, productFactory);
		this.productService = new ProductService(machine, productRepository);
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
	void 상품입력_포맷_예외테스트_입력값오류4_대괄호중복(){
		String product = "[[사이다,1000,10]]";
		validator.validateProductInputFormat(product);
		assertThat(output()).contains(PRODUCT_INPUT_FORMAT_EXCEPTION);
	}


	@Test
	void 상품_존재여부_예외테스트(){
		productService.saveAll(new String[]{"[치킨,1000,10]"});
		validator.addDependency(productService);
		assertEquals(validator.validateProductExisted("치킨"), true);
		assertEquals(validator.validateProductExisted("치킨1"), false);
		assertThat(output()).contains(PRODUCT_IS_NOT_EXISTED_EXCEPTION_MESSAGE);
	}


	@Test
	void 구매금액부족_예외테스트(){
		productService.saveAll(new String[]{"[치킨,10000,10]","[바나나,300,10]"});
		validator.addDependency(productService);
		assertEquals(validator.validateProductExisted("치킨"), false);
		assertThat(output()).contains(CUSTOMER_LEAK_MONEY_EXCEPTION_MESSAGE);
	}



	@Override
	protected void runMain() {
	}
}