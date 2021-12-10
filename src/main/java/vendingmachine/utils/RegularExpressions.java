package vendingmachine.utils;

public enum RegularExpressions {

    MACHINE_HAVE_MONEY_REGULAR_EXPRESSION("^[0-9]+$"),
    PRODUCT_NAME_REGULAR_EXPRESSION("^[가-힣]+$"),
    PRODUCT_INFORMATION_REGULAR_EXPRESSION("^\\[[가-힣]+,[0-9]+,[0-9]+\\]$");

    private final String regularExpression;

    RegularExpressions(final String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getRegularExpression() {
        return regularExpression;
    }

}
