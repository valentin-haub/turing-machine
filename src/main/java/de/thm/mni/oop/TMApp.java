package de.thm.mni.oop;

public class TMApp {
    public static void main(String[] args) {
        System.out.println("========== TURING MACHINE DEMO ==========" + "\n");
        System.out.println("This demo shows how the machine works in multiple scenarios." + "\n\n");

        // decrease
        System.out.println("--- Scenario 1: Binary Decrement (110 -> 101) ---");
        BasicOperations.decreaseBinary("110");
        System.out.println("\n");

        // increase
        System.out.println("--- Scenario 2: Binary Increment (101 -> 110) ---");
        BasicOperations.increaseBinary("101");
        System.out.println("\n");

        // shiftOnes
        System.out.println("--- Scenario 3: Shift Ones to the Right (1101 -> 0111) ---");
        BasicOperations.shiftOnesToTheRight("1101");
        System.out.println("\n");
        
    }
}