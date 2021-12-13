package vendingmachine.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductDtoTest {
	@Test
	@DisplayName("부적절한 입력값은 변환할 수 없다.")
	public void invalidInput() {
		ProductDto productDto = new ProductDto("[z,,]");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::toProducts);
		productDto = new ProductDto("[z,0,0];[,,]");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::toProducts);
		productDto = new ProductDto(";;");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::toProducts);
		productDto = new ProductDto("[콜라,1500,20");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::toProducts);
		productDto = new ProductDto("[콜,라,1500,20]");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::toProducts);
		productDto = new ProductDto("[콜라,1500,20];");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::toProducts);
		productDto = new ProductDto("[콜라,100]");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::toProducts);
	}

	@Test
	@DisplayName("제품들을 올바르게 생성할 수 있다.")
	public void createSuccess() {
		ProductDto productDto = new ProductDto("[콜라,1500,20];[사이다,1000,10]");
		productDto.toProducts();
		productDto = new ProductDto("[콜라,1500,20]");
		productDto.toProducts();
	}

	@Test
	@DisplayName("제품명이 중복될 수 없다.")
	public void duplicateFail() {
		ProductDto productDto = new ProductDto("[콜라,1500,20];[콜라,1000,10]");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::toProducts);
	}

}
