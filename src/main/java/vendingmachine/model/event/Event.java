package vendingmachine.model.event;

public class Event<T> {
	private final EventType type;
	private T data;

	public Event(EventType type, T data) {
		this.type = type;
		this.data = data;
	}

	public static <T> Event of(EventType type, T data) {
		return new Event(type, data);
	}

	public T getData() {
		return data;
	}

	public boolean isTypeOf(EventType type) {
		return this.type.equals(type);
	}
}
