package vendingmachine.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class CoinCounter {
	//  1) CountOf(ENUM), plusCount, plusCountFromList, minusCount, minusCountFromList
	//  2) @toString(기본 key -> value 형식), convertToString, calculate , createReadOnlyCounter
	//  3) isAnyAvailable() : 갯수가 1이상인게 하나라도 있는지
	//    isExist(input) -> isAvailable(input) : 검증용으로서, map에 존재하는지 + 1개이상 있는지
	//  4) forEach( (a,b) -> { } )
	private SortedMap<Coin, Integer> counterMap;

	public CoinCounter() {
		counterMap = new TreeMap<>();
		Arrays.stream(Coin.values())
			.forEach(enumObj -> counterMap.put(enumObj, 0));
	}

	public void plusCount(Coin coin) {
		counterMap.put(coin, counterMap.get(coin) + 1);
	}

	public void minusCount(Coin coin) {
		counterMap.put(coin, counterMap.get(coin) - 1);
	}

	public void plusCountFromList(List<Coin> list) {
		list
			.forEach(enumObj -> counterMap.put(enumObj, counterMap.get(enumObj) + 1));
		// list.stream()
		// 	.forEach(obj -> IntStream.range(0, obj.toCount())
		// 		.forEach(i -> counterMap.put(value, counterMap.getOrDefault(value, 0) + 1)));
	}

	public void minusCountFromList(List<Coin> list) {
		list
			.forEach(enumObj -> counterMap.put(enumObj, counterMap.get(enumObj) - 1));
	}

	public Integer CountOf(Coin coin) {
		return counterMap.get(coin);
	}

	@Override
	public String toString() {
		return counterMap.keySet()
			.stream()
			// .filter( key -> key.ordinal()>=3)
			.map(enumObjAsKey -> enumObjAsKey + " -> " + counterMap.get(enumObjAsKey) + "개")
			.collect(Collectors.joining(System.lineSeparator())); // 줄바꿈 단위로 붙임.
	}

	public Map<Coin, Integer> createReadOnlyCounter() {
		return Collections.unmodifiableMap(counterMap);
	}

	//8. (추가) 갯수가 1이상인게 하나라도 있는지
	public boolean isAnyAvailable() {
		return this.counterMap.keySet()
			.stream()
			.anyMatch(key -> counterMap.getOrDefault(key, 0) > 0);
	}

	//9. (추가2) 존재하는지 inputValue로 검색
	// public boolean isExist(String inputValue) {
	// 	return this.counterMap.keySet()
	// 		.stream()
	// 		.anyMatch( enumObj -> enumObj.isSame(inputValue)); // 조건에 맞게 isSame()함수 -> enum의 find() 함수쓰도록 수정하기**
	// }

	public boolean isAvailable(String inputValue) {
		Coin searchedCoin = findBy(inputValue);
		return this.counterMap.getOrDefault(searchedCoin, 0) > 0;
	}

	public Coin findBy(String inputValue) {
		return this.counterMap.keySet()
			.stream()
			.filter(enumObj -> enumObj.toString().equals(inputValue)) // 조건 맞게 바꾸기
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다. 다시 입력해주세요."));
	}

	public void forEach(BiConsumer<Coin, Integer> action) {
		this.counterMap.forEach(action);
	}
}
