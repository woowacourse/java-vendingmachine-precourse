package vendingmachine.utils;

public enum Symbol {
    COMMA(","),
    SEMI_COLON(";"),
    NEW_LINE("\n"),
    BLANK(""),
    FRONT_SQUARE_BRACKET("\\["),
    REAR_SQUARE_BRACKET("]");

    private final String symbol;

    Symbol(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
