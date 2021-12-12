package vendingmachine;

import java.util.HashMap;

public class Parser {
    public String parseHolding(HashMap<Integer, Integer> count) {
        String result = "";
        for (int key : count.keySet()) {
            result += key + "원 - " + count.get(key) + "개 \n";
        }
        return result;
    }
}
