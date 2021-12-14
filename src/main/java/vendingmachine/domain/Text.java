package vendingmachine.domain;

public class Text {
    public static final String REGEX_NUMBER = "^[0-9]+$";
    public static final String REGEX_ITEM_FORM = "^\\[[^,\\[\\];]+,[-+]?[0-9]+,[-+]?[0-9]+\\]$";
    public static final String REGEX_ITEM_NAME = "\\[(.+),[-+]?[0-9]+,[-+]?[0-9]";
    public static final String REGEX_ITEM_PRICE = ",(.+),";
    public static final String REGEX_ITEM_STOCK = "[-+]?[0-9],(.+)\\]";
    public static final String SEMICOLON = ";";
}
