package vendingmachine.service;

import vendingmachine.repository.ChangeRepository;
import vendingmachine.view.InputViews;

import static vendingmachine.service.Validator.*;

public class ChangeService {

    private static ChangeRepository changeRepository;

    public void getInitUserChange() {
        while (true) {
            String input = InputViews.inputUserMoney();
            try {
                int inputMoney = checkNotString(input);
                checkPositiveNumber(inputMoney);
                checkDivideByTen(inputMoney);
                changeRepository.initChange(inputMoney);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
