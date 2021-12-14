package vendingmachine;

public class Application {
	private static final String BRACKET_PAIRS_PATTERN = "\\[.*]";

	public static void main(String[] args) {
		Program p = new Program();
		p.start();
	}
}
