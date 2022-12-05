package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Change;
import vendingmachine.util.Message;
import vendingmachine.validate.Validator;

import static vendingmachine.validate.Validator.*;

public class View {
    public void printAskInputChange(){
        System.out.println(Message.MACHINE_CHANGE.getMessage());
    }
    public Change inputChange(){
        printAskInputChange();
        Change change;
        String inputChange = Console.readLine();
        try{
            inputDigitalValidator(inputChange);
            change = new Change(Integer.parseInt(inputChange));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputChange();
        }
        return change;
    }
}
