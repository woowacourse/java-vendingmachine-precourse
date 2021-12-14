package vendingmachine.view;

import java.util.Observer;

import vendingmachine.model.event.Event;

public abstract class View implements Observer {
	protected Event convertToEvent(Object obj) {
		return (Event) obj;
	}

	protected <T> T convertToData(Object data, Class<T> clazz) {
		return (T) data;
	}
}
