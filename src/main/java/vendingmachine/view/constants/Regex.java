package vendingmachine.view.constants;

public class Regex {
    public static final String REGEX_MONEY_NUMERIC = "[1-9]\\d*0";

    public static final String REGEX_DRINK_INPUT_FORMAT = "((\\[[ㄱ-ㅎ가-힣]{1,}),([1-9]\\d*0),([1-9]\\d*)\\](;)?){1,}";
    public static final String REGEX_SELECT_BRACKETS = "[\\[\\]]";

    public static final String REGEX_ONLY_KOREAN_LETTER = "([ㄱ-ㅎ가-힣]){1,}";
}
