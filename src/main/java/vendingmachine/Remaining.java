package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Remaining<T> {
	private HashMap <T,Integer> remain;

	Remaining(T t) {
		remain = new HashMap<T, Integer>();
	}

	public void put(T t, Integer num) {
		// 상품 세팅 하는 경우 반환하는 에러
		if (num < 0) {
			throw new IllegalArgumentException("[ERROR] 음수의 개수는 사용할 수 없습니다.");
		}
		remain.put(t,num);
	}

	public int get(T t) {
		return remain.get(t);
	}

	public void deduct(T t) {
		// 주문 받는 경우 반환하는 에러
		if (isEmpty(t)) {
			throw new IllegalArgumentException("[ERROR] 남은 개수가 없는 것은 차감할 수 없습니다.");
		}

		int remainOfThis = remain.get(t);
		put(t, remainOfThis-1);
	}

	public boolean isEmpty(T t) {
		return remain.get(t) <= 0;
	}

	public boolean containsKey(T t) {
		return remain.containsKey(t);
	}


	public Set<String> keySet(T t) {
		Set<String> keyNameSet = new HashSet<>();
		remain.keySet().forEach(keyName -> keyNameSet.add(keyName.toString()));

		return keyNameSet;
	}
}
