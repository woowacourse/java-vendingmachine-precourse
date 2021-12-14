package vendingmachine.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//  1) CountOf(ENUM), plusCount, plusCountFromList, minusCount, minusCountFromList
//  2) @toString(기본 key -> value 형식), convertToString, calculate , createReadOnlyCounter
//  3) isAnyAvailable() : 갯수가 1이상인게 하나라도 있는지
//    isExist(input) -> isAvailable(input) : 검증용으로서, map에 존재하는지 + 1개이상 있는지
//  4) forEach( (a,b) -> { })
// -> 그외에 결과값List를 받는다거나.. or 메서드 정의 하지말고, [[[싱글톤내에서 inesrted된 변수활용]]]하도록,  plusCount( 개별 결과값 )정도만 쓴다.
public class ProductCounter {
	private SortedMap<Product, Integer> counterMap;

	public ProductCounter() {
		counterMap = new TreeMap<>(Comparator.comparingInt(Product::toAmount).reversed());
	}

	public void plusCount(Product value) {
		counterMap.put(value, counterMap.getOrDefault(value, 0) + 1);
	}

	public void minusCount(Product value) {
		counterMap.put(value, counterMap.getOrDefault(value, 0) - 1);
	}

	public void plusCountFromList(List<Product> list) {
		// list.stream()
		// 	.forEach( keyObj -> counterMap.put(keyObj, counterMap.get(keyObj) + 1));
		list.stream()
			.forEach(keyObj -> IntStream.range(0, keyObj.toCount()) // 객체내부에된 count만큼 돌기
				.forEach(i -> counterMap.put(keyObj, counterMap.getOrDefault(keyObj, 0) + 1)));
	}

	public void minusCountFromList(List<Product> list) {
		list.stream()
			.forEach(value -> counterMap.put(value, counterMap.getOrDefault(value, 0) - 1));
	}

	public Integer CountOf(Product value) {
		return counterMap.getOrDefault(value, 0);
	}

	@Override
	public String toString() {
		return counterMap.keySet()
			.stream()
			// .filter()
			.map(key -> key.toString() + " -> " + counterMap.getOrDefault(key, 0) + "개")
			.collect(Collectors.joining(System.lineSeparator())); // 줄바꿈 단위로 붙임.
	}

	////7. toString말고 따로 커스텀해서 문자열 반환받기
	// public String convertToString() {
	// 	return this.counterMap.keySet()
	// 		.stream()
	// 		.map(key -> {
	// 			// Integer counter = this.counterMap.getOrDefault(key, 0);
	// 			// int prize = key.toPrize();
	// 			// if (key.isBonus()) {
	// 			// 	return String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개", count, prize, counter);
	// 			// }
	// 			// return String.format("%d개 일치 (%d원)- %d개", count, prize, counter);
	// 		})
	// 		.collect(Collectors.joining(System.lineSeparator()));
	// }

	// //8. key + value를 사용한 계산식
	// //TODO: 추후 나누기 들어갈시 double로 반환
	// public double calculate() {
	// 	return this.counterMap.keySet()
	// 		.stream()
	// 		.mapToDouble(key -> {
	// 			// Integer counter = this.counterMap.getOrDefault(key, 0);
	// 			// int prize = enumValue.toPrize();
	// 			// return counter * prize;
	// 		})
	// 		// .peek( key-> System.out.println("등수별 상금들 : " + this.counterMap.getOrDefault(value, 0)(key)))
	// 		.sum();
	// }

	//7. 읽기전용map만 반환할때
	public Map<Product, Integer> createReadOnlyCounter() {
		return Collections.unmodifiableMap(counterMap);
	}

	//8. (추가) 갯수가 1이상인게 하나라도 있는지
	public boolean isAnyAvailable() {
		return this.counterMap.keySet()
			.stream()
			.anyMatch(key -> counterMap.getOrDefault(key, 0) > 0);
	}

	// //9. (추가2) 존재하는지 inputValue로 검색
	// public boolean isExist(String inputValue) {
	// 	return this.counterMap.keySet()
	// 		.stream()
	// 		.anyMatch( key -> key.isSame(inputValue)); // 조건에 맞게 isSame()함수 작성
	// }

	public Product findBy(String inputValue) {
		return this.counterMap.keySet()
			.stream()
			.filter(key -> key.toString().equals(inputValue)) // 조건 맞게 바꾸기
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다. 다시 입력해주세요."));
	}

	public boolean isAvailable(Product product) {
		return this.counterMap.getOrDefault(product, 0) > 0;
	}

	public void forEach(BiConsumer<Product, Integer> action) {
		this.counterMap.forEach(action);
	}

}
