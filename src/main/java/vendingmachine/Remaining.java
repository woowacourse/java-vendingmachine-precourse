package vendingmachine;

import java.util.HashMap;
import java.util.Set;

public class Remaining<T> {
	private final HashMap<T, Integer> remain = new HashMap<>();

	public void put(T object, Integer num) {
		if (num < 0) {
			throw new IllegalArgumentException("[ERROR] 음수의 개수는 사용할 수 없습니다.");
		}
		remain.put(object, num);
	}

	public int get(T object) {
		return remain.get(object);
	}

	public void deduct(T object) {
		if (isEmpty(object)) {
			throw new IllegalArgumentException("[ERROR] 남은 개수가 없는 것은 차감할 수 없습니다.");
		}

		int remainOfThis = remain.get(object);
		put(object, remainOfThis - 1);
	}

	public boolean isEmpty(T object) {
		return remain.get(object) <= 0;
	}

	public Set<T> keySet() {
		return remain.keySet();
	}
}
