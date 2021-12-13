package vendingmachine.util.validator;

import vendingmachine.util.ErrorMessage;

import java.util.List;

public class MerchandiseNameValidator implements InputValidator {
    private static final MerchandiseNameValidator instance = new MerchandiseNameValidator();
    private List<String> merchandiseNames;


    private MerchandiseNameValidator() {
    }

    public static MerchandiseNameValidator getInstance() {
        return instance;
    }

    public void setMerchandiseNames(List<String> merchandiseNames) {
        this.merchandiseNames = merchandiseNames;
    }

    @Override
    public void validate(String input) {
        if (merchandiseNames.stream().noneMatch(name -> name.equals(input))) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_EXIST_MERCHANDISE_NAME.getMessage());
        }
    }
}
