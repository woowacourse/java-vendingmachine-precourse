package utils;

import vendingmachine.MachineAmount;

import java.util.function.Supplier;

public class RepeatInput {

    public static <T> T repeatWhenInvalid(Supplier<T> input) {
        try {
            return input.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatWhenInvalid(input);
        }
    }
}
