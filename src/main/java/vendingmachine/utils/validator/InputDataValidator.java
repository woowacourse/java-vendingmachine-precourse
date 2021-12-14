package vendingmachine.utils.validator;

public interface InputDataValidator {

    void validateSingleFormatSize(String data);

    void validateNumber(String data);

    void validateData(String data);
}
