package vendingmachine.constant;

public enum Symbol {
	BRACKET_OPEN("["),
	BRACKET_CLOSE("]"),
	PRODUCT_DELIMITER(";"),
	PRODUCT_INFO_DELIMITER(",");

	private final String symbol;

	Symbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
}
