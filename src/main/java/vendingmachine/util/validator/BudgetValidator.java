package vendingmachine.util.validator;

public class BudgetValidator extends  Validator{
    @Override
   public void validate(String input) throws IllegalArgumentException {
        validateNumeric(input);
        validateRange(input);
    }
}
