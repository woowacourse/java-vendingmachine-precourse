package vendingmachine.reader;

public class RecursiveReader<T> {
	private final Reader<T> reader;

	public RecursiveReader(Reader<T> reader) {
		this.reader = reader;
	}

	public T read() {
		try {
			return reader.read();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return read();
		}
	}
}
