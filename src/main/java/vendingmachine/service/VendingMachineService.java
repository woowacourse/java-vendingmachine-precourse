package vendingmachine.service;


import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.Message;
import vendingmachine.utils.Validation;
import vendingmachine.view.InputView;

public class VendingMachineService {

    private final Validation validation;

    public VendingMachineService() {
        this.validation = new Validation();
    }

    public VendingMachine setVendingMachine(){
        while(true){
            System.out.println(Message.VENDINGMACHINE_INPUT);
            String input = InputView.inputVendingMachinePrice();
            try{
                validation.vendingMachinePriceValidation(input);
                VendingMachine vendingMachine = new VendingMachine(Integer.valueOf(input));
                return vendingMachine;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }



}
