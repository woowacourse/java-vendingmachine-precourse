package vendingmachine.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Products {
	private List<Product> products;

	public Products(List<String> list) {
		this.products = list.stream()
			.map(element -> {
				String[] splited = element.split(",");
				return Product.of(splited[0], splited[1], splited[2]);
			})
			.collect(Collectors.toList());
	}

	public static Products from(List<String> list) {
		return new Products(list);
	}

	public boolean isContains(Product product) {
		return this.products.contains(product);
	}

	public List<Product> toList() {
		return this.products;
	}

	// 집계===========
	// // 단일객체가 comparable -> compareTo 오버라이딩하여, 정렬/집계/비교의 기준이 정해졌을 때, 집계의 기준에 넣는다.
	// public int findMax() {
	// 	return this.cars.stream()
	// 		.max(Product::compareTo) // 집계함수의 결과도 reduce처럼 Optional이다. -> get보다는.. orElseThrow()로 가야할듯?
	// 		.get()
	// 		.getPosition();
	// }

	//TODO: 기존 List<결과값>을 대신하는 것이라면, 해당 list자리에
	//===========================
	// this.stream()... .collect(Collectors.toLit()) 자리에
	// -> Products.from(   ) 를 씌워서, 일급컬렉션 객체로 만들어줘야하다.!!!
	//===========================

	// 검색용===========================
	// String Name으로 단일객체 검색
	// public Product findByName(String name) {
	// 	return this.products.stream()
	// 		.filter(product -> product.isSameName(Name.of(
	// 			name))) // Name객체가 있다 + 단일객체에 equals나 혹은 isSameName(return this.name.equals(productName);)정의해줘야한다.
	// 		.findFirst()
	// 		.orElse(null);
	// }

	// Name객체로 단일객체 검색
	// public Product findByName(Name productName) {
	// 	return this.products.stream()
	// 		.filter(product -> product.isSameName(
	// 			productName)) // 단일객체에 equals나 혹은 isSameName(return this.name.equals(productName);)정의해줘야한다.
	// 		.findFirst()
	// 		.orElse(null);
	// }

	// 특정 숫자변수의 최대or최소값을 가지는 단일객체 검색
	// public Product findMinProduct() {
	// 	return this.products.stream()
	// 		.min(Comparator.comparingInt(
	// 			Product::toAmount)) // ::숫자래핑클래스에 getter, toXXX()정의 + 단일객체에 기준숫자형변수 getter정의해줘야한다. or compareTo해줘도 될듯.
	// 		.orElse(null);
	// }
}
