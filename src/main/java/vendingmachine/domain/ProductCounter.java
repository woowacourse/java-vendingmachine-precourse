package vendingmachine.domain;

import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import vendingmachine.utils.Constant;

public class ProductCounter {
	private SortedMap<Product, Integer> counterMap;

	public ProductCounter() {
		counterMap = new TreeMap<>(Comparator.comparingInt(Product::toAmount).reversed());
	}

	public void minusCount(Product value) {
		counterMap.put(value, counterMap.getOrDefault(value, Constant.CONSTANT_ZERO) - Constant.CONSTANT_ONE);
	}

	public void plusCountFromList(List<Product> list) {
		list.stream()
			.forEach(keyObj -> IntStream.range(Constant.CONSTANT_ZERO, keyObj.toCount())
				.forEach(i -> counterMap.put(keyObj,
					counterMap.getOrDefault(keyObj, Constant.CONSTANT_ZERO) + Constant.CONSTANT_ONE)));
	}

	@Override
	public String toString() {
		return counterMap.keySet()
			.stream()
			.map(key -> key.toString() + Constant.CONSTANT_ARROW + counterMap.getOrDefault(key, Constant.CONSTANT_ZERO)
				+ Constant.CONSTANT_COUNT)
			.collect(Collectors.joining(System.lineSeparator()));
	}

	public boolean isAnyAvailable() {
		return this.counterMap.keySet()
			.stream()
			.anyMatch(key -> counterMap.getOrDefault(key, Constant.CONSTANT_ZERO) > Constant.CONSTANT_ZERO);
	}

	public boolean isAvailable(Product product) {
		return this.counterMap.getOrDefault(product, Constant.CONSTANT_ZERO) > Constant.CONSTANT_ZERO;
	}

}
