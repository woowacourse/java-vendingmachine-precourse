package vendingmachine.utils.productchecker;

import vendingmachine.utils.datatypechecker.StringChecker;

public class NameChecker {
    static private final String CONTENT_TYPE = "상품명";

    static void checkName(String name) throws IllegalArgumentException{
        StringChecker.checkStringLength(name, CONTENT_TYPE);
    }

}
