package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;

public class MerchandiseList {
    final static int MERCHANDISE_NAME_INDEX = 0;
    final static int MERCHANDISE_PRICE_INDEX = 1;
    final static int MERCHANDISE_QUANTITY_INDEX = 2;
    final static int SUBSTRING_BRACKET_INDEX = 1;
    final static int MERCHANDISE_INFO_COUNT = 3;

    private ArrayList<Merchandise> merchandiseList;

    public MerchandiseList() {
        merchandiseList = new ArrayList<Merchandise>();
    }

    public String getAllMerchandiseInfo() {
        ArrayList<String> list = new ArrayList<String>();
        for (Merchandise merchandise : merchandiseList) {
            list.add(merchandise.toString());
        }
        return String.join(",", list);
    }

    public void addAllMerchandise(String merchandises) throws IllegalArgumentException {
        for (String merchandise : merchandises.split(";")) {
            isCorrectBracket(merchandise);
            addMerchandise(merchandise.substring(SUBSTRING_BRACKET_INDEX, (merchandise.length() - 1)));
        }
    }

    public void isCorrectBracket(String merchandise) throws IllegalArgumentException {
        if (!merchandise.startsWith("[") || !merchandise.endsWith("]")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CORRECT_BRACKET.print());
        }
    }

    public void addMerchandise(String merchandise) throws IllegalArgumentException {
        ArrayList<String> array = new ArrayList<String>(Arrays.asList(merchandise.split(",")));

        isBlank(merchandise);
        isNullInList(array);

        merchandiseList.add(new Merchandise(array.get(MERCHANDISE_NAME_INDEX),
                array.get(MERCHANDISE_PRICE_INDEX),
                array.get(MERCHANDISE_QUANTITY_INDEX)));
    }

    private void isBlank(String merchandise) throws IllegalArgumentException {
        if (merchandise.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE.print());
        }
    }

    public void isNullInList(ArrayList<String> array) {
        if (array.size() < MERCHANDISE_INFO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NULL_IN_LIST.print());
        }
    }
}

