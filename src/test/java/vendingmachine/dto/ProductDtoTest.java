package vendingmachine.dto;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;

class ProductDtoTest {
	@Test
	@DisplayName("부적절한 입력값은 변환할 수 없다.")
	public void invalidInput() {
		ProductDto productDto = new ProductDto("[z,,]");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::convertProducts);
		productDto = new ProductDto("[z,0,0];[,,]");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::convertProducts);
		productDto = new ProductDto(";;");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::convertProducts);
		productDto = new ProductDto("[콜라,1500,20");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::convertProducts);
		productDto = new ProductDto("[콜,라,1500,20]");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::convertProducts);
		productDto = new ProductDto("[콜라,1500,20];");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::convertProducts);
		productDto = new ProductDto("[콜라,100]");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::convertProducts);
	}

	@Test
	@DisplayName("제품들을 올바르게 생성할 수 있다.")
	public void createSuccess() {
		ProductDto productDto = new ProductDto("[콜라,1500,20];[사이다,1000,10]");
		productDto.convertProducts();
		productDto = new ProductDto("[콜라,1500,20]");
		productDto.convertProducts();
	}

	@Test
	@DisplayName("제품명이 중복될 수 없다.")
	public void duplicateFail() {
		ProductDto productDto = new ProductDto("[콜라,1500,20];[콜라,1000,10]");
		Assertions.assertThrows(IllegalArgumentException.class, productDto::convertProducts);
	}


}
