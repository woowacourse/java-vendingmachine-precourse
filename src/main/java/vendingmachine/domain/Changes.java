package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.Map;
import vendingmachine.Coin;

public class Changes {

    private Map<Integer, Integer> changes = new LinkedHashMap<>();

    public Changes(String inputMoney) {
        validInputMoney(inputMoney);
        prepareChanges(Integer.parseInt(inputMoney));
    }

    private void validInputMoney(String stringChange) {
        validInteger(stringChange);
        graterThanZero(stringChange);
    }

    private void validInteger(String stringChange) {
        try {
            Integer.parseInt(stringChange);
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] : 숫자로 이루어져야 합니다.");
        }
    }

    private void graterThanZero(String stringChange) {
        Integer change = Integer.parseInt(stringChange);
        if (change < 10) {
            throw new IllegalArgumentException("[ERROR] : 잔돈은 10원 이상의 값을 입력하여야 합니다.");
        }

        if (change % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] : 상품 가격은 10원으로 나누어 떨어져야 합니다.");
        }
    }

    private void prepareChanges(int inputMoney) {

        for (Integer change : Coin.amounts()) {
            changes.put(change, 0);
        }

        while (totalChanges() < inputMoney) {
            int randomChanges = Randoms.pickNumberInList(Coin.amounts());
            if (totalChanges() + randomChanges <= inputMoney) {
                changes.put(randomChanges, changes.get(randomChanges) + 1);
            }
        }
    }

    public int totalChanges() {

        return changes.keySet().stream()
            .map(change -> this.changes.get(change) * change)
            .reduce(Integer::sum)
            .orElse(0);
    }

    public Map<Integer, Integer> changes() {
        return changes;
    }

    public Map<Integer, Integer> calculateChangeToCustomer(int customerInputMoney) {
        Map<Integer, Integer> changeToCustomerInfo = new LinkedHashMap<>();
        for (Integer change : Coin.amounts()) {
            if (customerInputMoney > total(changeToCustomerInfo)) {
                calculateChangesToCustomerByCange(customerInputMoney, changeToCustomerInfo, change);
            }
        }

        return changeToCustomerInfo;
    }

    private void calculateChangesToCustomerByCange(
        int customerInputMoney,
        Map<Integer, Integer> changeToCustomerInfo,
        Integer change
    ) {
        int frequency = calculateFrequency(customerInputMoney, changeToCustomerInfo, change);
        if (frequency != 0) {
            changes.put(change, changes.get(change) - frequency);
            changeToCustomerInfo
                .put(change, changeToCustomerInfo.getOrDefault(customerInputMoney, 0) + frequency);
        }
    }

    private int calculateFrequency(int customerInputMoney,
        Map<Integer, Integer> changeToCustomerInfo, Integer change) {
        int frequency = changes.get(change);
        int reaminingPayment = customerInputMoney - total(changeToCustomerInfo);

        if (frequency * change >= reaminingPayment) {
            frequency = (reaminingPayment) / change;
        }

        return frequency;
    }

    private int total(Map<Integer, Integer> changeToCustomerInfo) {
        int total = 0;
        for (Integer change : changeToCustomerInfo.keySet()) {
            int count = changeToCustomerInfo.get(change);
            total += change * count;
        }
        return total;
    }
}
