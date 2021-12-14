package vendingmachine.service;

import java.util.LinkedHashMap;

public class MessageFormatService {
    public String makeHoldingMessage(LinkedHashMap<Integer, Integer> count) {
        StringBuilder result = new StringBuilder();
        for (int key : count.keySet()) {
            result.append(key + "원 - " + count.get(key) + "개 \n");
        }
        return result.toString();
    }

    public String makeLastChanges(LinkedHashMap<Integer, Integer> map) {
        StringBuilder result = new StringBuilder();
        for (int amount : map.keySet()) {
            result.append(amount + "원 - " + map.get(amount) + "개 \n");
        }
        return result.toString();
    }
}
