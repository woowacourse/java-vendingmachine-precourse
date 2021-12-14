package vendingmachine.view;

import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineController;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static vendingmachine.constant.Constant.PRODUCT_SPLITTER;
import static vendingmachine.constant.Message.*;
import static vendingmachine.exception.PriceValidator.*;
import static vendingmachine.exception.ProductValidator.*;

public class Input {
    Output output = new Output();

    public int inputMachineMoney(){
        while (true) {
            output.printInitMoney();
            String input = readLine();
            try {
                validateInitPrice(input);
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public String inputProducts(){
        while (true) {
            output.printInsertProduct();
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
    public int inputUserMoney(){
        while (true) {
            System.out.println();
            output.printInserMoney();
            String input = readLine();
            try {
                validateInitPrice(input);
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputBuyProduct(Machine machine){
        while (true){
            System.out.println();
            output.printBuy(machine);
            String input = readLine();
            try{
                validateIsIn(machine,input);
                validateCanBuy(machine,input);
                return input;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
