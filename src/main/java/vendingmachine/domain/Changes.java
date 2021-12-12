package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.Map;
import vendingmachine.Coin;

public class Changes {

    private static final String CHANGE_IS_INTEGER = "[ERROR] : 숫자로 이루어져야 합니다.";
    private static final String CHANGE_IS_OVER_THAN_TEN = "[ERROR] : 잔돈은 10원 이상의 값을 입력하여야 합니다.";
    private static final String CHANGE_IS_MULTIPLE_OF_TEN = "[ERROR] : 상품 가격은 10원으로 나누어 떨어져야 합니다.";
    private static final Integer DEFAULT = 0;
    private static final Integer MULTIPLE_THRETHOLD = 10;
    private static final Integer MINIMUM = 10;

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
            throw new IllegalArgumentException(CHANGE_IS_INTEGER);
        }
    }

    private void graterThanZero(String stringChange) {
        Integer change = Integer.parseInt(stringChange);
        if (change < MINIMUM) {
            throw new IllegalArgumentException(CHANGE_IS_OVER_THAN_TEN);
        }

        if (change % MULTIPLE_THRETHOLD != 0) {
            throw new IllegalArgumentException(CHANGE_IS_MULTIPLE_OF_TEN);
        }
    }

    private void prepareChanges(int inputMoney) {

        for (Integer change : Coin.amounts()) {
            changes.put(change, DEFAULT);
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
            .orElse(DEFAULT);
    }

    public Map<Integer, Integer> changes() {
        return changes;
    }

    public Map<Integer, Integer> calculateChangeToCustomer(int customerInputMoney) {
        Map<Integer, Integer> changeToCustomerInfo = new LinkedHashMap<>();
        for (Integer change : Coin.amounts()) {
            if (customerInputMoney > total(changeToCustomerInfo)) {
                calculateChangesToCustomerByChange(customerInputMoney, changeToCustomerInfo, change);
            }
        }

        return changeToCustomerInfo;
    }

    private void calculateChangesToCustomerByChange(
        int customerInputMoney,
        Map<Integer, Integer> changeToCustomerInfo,
        Integer change
    ) {
        int frequency = countNumberofChange(customerInputMoney, changeToCustomerInfo, change);
        // 인자로 받은 change (잔돈)이 자판기에 존재한다면, 고객에게 줄 잔돈을 계산하겠다.
        if (frequency != 0) {
            // 자판기에 있는 잔고는 줄어들고
            changes.put(change, changes.get(change) - frequency);
            // 고객에게 줄 잔고는 늘어난다.
            changeToCustomerInfo.put(change, changeToCustomerInfo.getOrDefault(customerInputMoney, DEFAULT) + frequency);
        }
    }

    private int countNumberofChange(
        int customerInputMoney,
        Map<Integer, Integer> changeToCustomerInfo,
        Integer change
    ) {
        // 고객에게 줘야하는 잔돈의 개수를 계산하는 과정
        int frequency = changes.get(change);
        int reaminingPayment = customerInputMoney - total(changeToCustomerInfo);

        if (frequency * change >= reaminingPayment) {
            frequency = (reaminingPayment) / change;
        }

        return frequency;
    }

    private int total(Map<Integer, Integer> changeToCustomerInfo) {
        int total = DEFAULT;
        for (Integer change : changeToCustomerInfo.keySet()) {
            int count = changeToCustomerInfo.get(change);
            total += change * count;
        }
        return total;
    }
}
