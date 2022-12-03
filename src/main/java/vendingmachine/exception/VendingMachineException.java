package vendingmachine.exception;

public class VendingMachineException {
    private final String ONLY_NUMBER = "^[0-9]$";

    public void validInputMoney(String money){
        validVendingMachineMoney(money);
    }

    private void validVendingMachineMoney(String money){
        if(!money.matches(ONLY_NUMBER))
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력하세요.");
    }
}
