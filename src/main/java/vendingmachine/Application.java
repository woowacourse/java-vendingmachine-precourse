package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        try {
            simulator.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
