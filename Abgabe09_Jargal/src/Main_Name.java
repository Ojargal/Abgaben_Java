/**
 *Main class of the program that handles user input
 * and displays name-related information.
 *
 * the program prompts the user to enter their first and last name,
 * creates {@code Name} object, and prints the initials,
 * account name, and a comparison result.
 *
 * @author Jargal
 * @version 1.0
 */

import java.util.Scanner;
public class Main_Name {
    /**
     * Entry point of the program.
     * Prompts the user for their first and last name, creates a {@code Name} object,
     * and prints the initials, account name, and comparison result.
     *
     * @param args command-line argument(not used)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Geben Sie bitte Vorname ein: ");
        String vorname = sc.nextLine();
        System.out.println("Geben Sie bitte Nachname ein: ");
        String nachname = sc.nextLine();
        Name nv = new Name(nachname, vorname);

        System.out.println(nv.getInitialen());
        System.out.println(nv.getAccount());
        System.out.println(nv.gleich());

        sc.close();
    }
}