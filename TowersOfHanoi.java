/*
 * This program solves the Towers of Hanoi problem with the user-inputted
 * amount of rings.
 *
 * @author  Ryan Chung
 * @version 1.0
 * @since   2021-12-04
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class contains the solution to the Towers of Hanoi.
 * */
final class TowersOfHanoi {

    /**
    * Prevents instantiation.
    * Throw an exception IllegalStateException when called.
    *
    * @throws IllegalStateException
    *
    */
    private TowersOfHanoi() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Uses recursion to complete the hanoi algorithm and move all the rings to
     * the final rod.
     *
     * @param ring the amount of rings, but also the ring currently being
     *     moved.
     * @param from_rod is the initial rod
     * @param to_rod is the final rod
     * @param mid_rod is the middle rod
     * @throws IOException if there is anything wrong with the user input.
     * @throws NumberFormatException if the user input cannot be turned into
     *     an integer.
     * */
    public static void hanoi(
            int ring, char from_rod, char to_rod, char mid_rod) {

        final String toRod = " to rod ";

        if (ring > 1) {
            hanoi(ring - 1, from_rod, mid_rod, to_rod);

            System.out.println("Move disk " + ring + " from rod "
                    + from_rod + toRod + to_rod);

            hanoi(ring - 1, mid_rod, to_rod, from_rod);
        } else if (ring == 1) {
            System.out.println("Move disk 1 from rod "
                    + from_rod + toRod + to_rod);
        } else {
            System.out.println("Please enter a number higher than 0.");
        }
    }

    /**
     * Solves the towers of hanoi.
     *
     * @param args No args will be used.
     * @throws IOException if there is anything wrong with the user input.
     * @throws NumberFormatException if the user input cannot be turned into
     *     an integer.
     * */
    public static void main(String[] args) {
        try {
            System.out.print("Choose the amount of rings: ");

            final String ringsString = new BufferedReader(
                    new InputStreamReader(System.in)
            ).readLine();

            final int rings = Integer.parseInt(ringsString);

            System.out.print("\n");

            hanoi(rings, 'A', 'C', 'B');
        } catch (NumberFormatException | IOException exception) {
            System.out.println("Please enter an integer.");
        }

        System.out.println("\nDone.");
    }
}

