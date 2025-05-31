package mod07_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A simple application that calculates factorial values both recursively 
 * and iteratively, and performs a binary search on a list of integers.
 * 
 * @author angel
 */
public class App {

    /**
     * Main method to run the application. It interacts with the 
     * user to input a value for factorial calculations and performs 
     * binary search on a predefined list of integers.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        
        // Scanner to read input from the user
        Scanner kbdIn = new Scanner(System.in);
        
        System.out.println("Factorial Calculation");

        // Loop until a negative number is entered
        while (true) {
            
            System.out.println();
            System.out.print("Enter n for factorial (negative to exit): ");
            int n = kbdIn.nextInt();
            
            // Exit loop if a negative number is entered
            if (n < 0)
                break;
            
            // Display recursive and iterative factorial results
            System.out.println(n + "! recursive = " + factorialR(n));
            System.out.println(n + "! iterative = " + factorialI(n));
        }
        
        // Close the scanner after use
        kbdIn.close();
        
        System.out.println();
        System.out.println("Binary Search");

        // Create and initialize a list of integers for binary search
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(11);
        list.add(19);
        list.add(101);
        list.add(135);
        list.add(175);
        list.add(199);

        // Perform binary search on the list
        System.out.println("Find 19: " + findIndex(list, 19));
        System.out.println("Find 35: " + findIndex(list, 35));
        System.out.println("Find 175: " + findIndex(list, 175));
    }

    /**
     * Performs a binary search to find the index of a target value in a list.
     * 
     * @param list   The list of integers to search.
     * @param target The target value to search for.
     * @return The index of the target value in the list, or null if not found.
     */
    public static Integer findIndex(List<Integer> list, Integer target) {
        
        // Return null if the list is empty
        if (list.size() == 0)
            return null;
        
        // Find the middle index of the list
        Integer mid = list.size() / 2;

        // Compare target to the middle value
        if (target.compareTo(list.get(mid)) < 0) {
            // Recursively search in the left sublist
            return findIndex(list.subList(0, mid), target);
        }
        
        if (target.compareTo(list.get(mid)) > 0) {
            // Recursively search in the right sublist
            Integer index = findIndex(list.subList(mid + 1, list.size()), target);
            
            // Adjust the index relative to the original list if found
            if (index != null) index += mid + 1;
            return index;
        }

        // Return the middle index if target is found
        return mid;
    }

    /**
     * Recursively calculates the factorial of a given number.
     * 
     * @param n The number to calculate the factorial for.
     * @return The factorial of the number.
     */
    public static int factorialR(int n) {
        
        // Base case: factorial of 0 is 1
        if (n == 0)
            return 1;
        
        // Recursive step
        return n * factorialR(n - 1);
    }

    /**
     * Iteratively calculates the factorial of a given number.
     * 
     * @param n The number to calculate the factorial for.
     * @return The factorial of the number.
     */
    public static int factorialI(int n) {
        
        int result = n;
        
        // Multiply n by decreasing numbers until 1
        for (int i = n - 1; i > 0; i--)
            result *= i;
        
        return result;
    }

}
