package hotelordersystem;
import java.util.Scanner;
/**
 *
 * @author UC
 */
public class HotelOrderSystem {

    /**
     * @param args the command line arguments
     */
    static final int MENU_SIZE = 5; // This constant should be defined in this class as well

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int[] no = new int[MENU_SIZE];
        int[] qty = new int[MENU_SIZE];
        String[] name = new String[MENU_SIZE];
        long[] price = new long[MENU_SIZE];
        float[] total = new float[MENU_SIZE];
        float jum = 0, pay, change;

        // Display hotel name and menu (Using HotelOrder class methods)
        HotelOrder.displayHotelName();
        HotelOrder.displayMenu();

        System.out.print("How many dishes would you like to order? (1-" + MENU_SIZE + "): ");
        n = sc.nextInt();

        if (n <= 0 || n > MENU_SIZE) {
            System.out.println("Invalid number of dishes. Please enter a number between 1 and " + MENU_SIZE + ".");
            return;
        }

        // Take the order from the user
        HotelOrder.takeOrder(no, qty, name, price, total, n);

        // Calculate the total bill
        for (int i = 0; i < n; i++) {
            jum += total[i];
        }

        // Display hotel name, menu, and final order summary
        HotelOrder.displayHotelName();
        HotelOrder.displayOrder(qty, name, price, total, n, jum);

        // Handle payment
        System.out.print("Enter the amount you will pay: Rs. ");
        pay = sc.nextFloat();

        if (pay >= jum) {
            change = pay - jum;
            System.out.printf("Payment successful! Your change is: Rs. %.2f\n", change);
        } else {
            System.out.printf("Insufficient payment. You still owe Rs. %.2f\n", jum - pay);
        }
    }
}