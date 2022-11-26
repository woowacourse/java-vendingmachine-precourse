package view;

import camp.nextstep.edu.missionutils.Console;
import dto.HoldingSumRequestDto;
import util.Validator;

public class InputView {
    public HoldingSumRequestDto inputHolingSum() {
        System.out.println(ViewConstant.ASKING_INPUT_HOLDING_SUM);
        String holdingSum = Console.readLine();
        Validator.validatePositiveInteger(holdingSum);
        return new HoldingSumRequestDto(Integer.parseInt(holdingSum));
    }
}
