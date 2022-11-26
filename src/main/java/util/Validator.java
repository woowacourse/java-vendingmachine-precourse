package util;

import constant.ErrorLog;

public class Validator {


    public static void validatePositiveInteger(String string) {
        if (!string.matches("^[0-9]{1,9}$")) {
            throw new IllegalArgumentException(ErrorLog.NOT_NUMBER_INPUT.getLog());
        }
    }
}
