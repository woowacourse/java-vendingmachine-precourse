package vendingmachine.utils.productchecker;

import vendingmachine.utils.datatypechecker.StringChecker;

import java.util.List;

public class NameChecker {
    static private final String CONTENT_TYPE = "상품명";

    static void checkName(String name) throws IllegalArgumentException{
        StringChecker.checkStringLength(name, CONTENT_TYPE);
    }

    static void checkSameName(List<String> names) throws IllegalArgumentException{
        StringChecker.checkSameString(names, CONTENT_TYPE);
    }

}
