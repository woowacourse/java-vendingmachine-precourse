package vendingmachine.domain;

import vendingmachine.utils.ExceptionMessages;

public class Count {

    private final int count;

    public Count(final int count) {
        this.count = count;
    }

    public int minusCount(int count) {
        return count - 1;
    }

    public void validateCount(int count) {
        if(minusCount(count) < 0){
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_COUNT_LESS_THAN_ZERO.getErrorMessage());
        }
    }

}
