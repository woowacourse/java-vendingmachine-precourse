package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    public static ArrayList splitString(String inputString) {
        String[] splits = inputString.replace("[","").replace("]","").split(";");
        return new ArrayList<String>(Arrays.asList(splits));
    }
}
