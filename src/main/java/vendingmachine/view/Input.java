package vendingmachine.view;

import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineController;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static vendingmachine.constant.Constant.PRODUCT_SPLITTER;
import static vendingmachine.exception.PriceValidator.*;
import static vendingmachine.exception.ProductValidator.validateSplitInfos;
import static vendingmachine.exception.ProductValidator.validateSplitProduct;


public class Input {
    public int inputMoney(){
        while (true) {
            String input = readLine();
            try {
                validatePrice(input);
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public String inputProducts(){
        while (true) {
            String input = readLine();
            try {
                validateSplitProduct(input);
                validateSplitInfos(input.split(PRODUCT_SPLITTER));
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
