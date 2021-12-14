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
		list.stream()
			.forEach(keyObj -> IntStream.range(0, keyObj.toCount())
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
			.map(key -> key.toString() + " -> " + counterMap.getOrDefault(key, 0) + "개")
			.collect(Collectors.joining(System.lineSeparator()));
	}

	public Map<Product, Integer> createReadOnlyCounter() {
		return Collections.unmodifiableMap(counterMap);
	}

	public boolean isAnyAvailable() {
		return this.counterMap.keySet()
			.stream()
			.anyMatch(key -> counterMap.getOrDefault(key, 0) > 0);
	}

	public Product findBy(String inputValue) {
		return this.counterMap.keySet()
			.stream()
			.filter(key -> key.toString().equals(inputValue))
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
