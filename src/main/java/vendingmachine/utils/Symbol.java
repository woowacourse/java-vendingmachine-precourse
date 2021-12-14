package vendingmachine.utils;

public enum Symbol {

    COMMA(","),
    SEMI_COLON(";"),
    NEW_LINE("\n"),
    BLANK(""),
    SPACE(" "),
    DASH("-"),
    FRONT_SQUARE_BRACKET("\\["),
    REAR_SQUARE_BRACKET("]"),
    WON("원"),
    EA("개"),
    CHANGE("잔돈");

    private final String symbol;

    Symbol(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
