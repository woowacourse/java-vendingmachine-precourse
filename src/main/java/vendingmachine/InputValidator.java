package vendingmachine;

public interface InputValidator {

    static void validateInsertedAmount(String insertedAmount) {
        if (insertedAmount.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INSERTED_AMOUNT.getCompleteMessage());
        }

        for (int i = 0 ; i < insertedAmount.length() ; i++ ) {
            if(!Character.isDigit(insertedAmount.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INSERTED_AMOUNT.getCompleteMessage());
            }
        }

        if (Integer.parseInt(insertedAmount) % 10 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_BY_10.getCompleteMessage());
        }
    }
}
