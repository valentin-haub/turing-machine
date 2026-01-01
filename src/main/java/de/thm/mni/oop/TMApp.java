package de.thm.mni.oop;

import java.util.Scanner;

public class TMApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        System.out.println("========== TURING MACHINE DEMO ==========" + "\n");
        System.out.println("This demonstration shows how the machine works in multiple scenarios.");
        System.out.println("Please type a binary number (up to 8 digits) which is going to be used by the demonstration.");
        System.out.println("Make sure to only use '0' and '1'! Press enter to confirm.");
        System.out.println("Tip: A mix of '0' and '1' (e.g. 11010) works best to demonstrate all algorithms.");
        System.out.println();

        while (true){
            System.out.print("Number: ");
            String line = sc.nextLine().trim();

            if (line.isBlank()){
                System.out.println("Error: Input is empty! Try again!");
                continue;
            }

            if (line.length() > 8){
                System.out.println("Error: Input too long! Maximum 8 digits. Try again!");
                continue;
            }

            boolean allCharsValid = true;
            for (char digit : line.toCharArray()){
                if (!(digit == '0' || digit == '1'))
                    allCharsValid = false;
            }

            if (!allCharsValid){
                System.out.println("Error: Invalid characters! Only '0' and '1' are allowed. Try again!");
                continue;
            }

            input = line;
            break;
        }
        System.out.println("\n");

        // decrease
        System.out.println("--- Scenario 1: Binary Decrement (" + input + ") ---");
        BasicOperations.decreaseBinary(input);
        System.out.println("\n");

        // increase
        System.out.println("--- Scenario 2: Binary Increment (" + input + ") ---");
        BasicOperations.increaseBinary(input);
        System.out.println("\n");

        // shiftOnes
        System.out.println("--- Scenario 3: Shift Ones to the Right (" + input + ") ---");
        BasicOperations.shiftOnesToTheRight(input);
        System.out.println("\n");
        
        sc.close();
    }
}