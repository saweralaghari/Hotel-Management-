package hotelordersystem;
import java.util.Scanner;
/**
 *
 * @author UC
 */
public class HotelOrder {
    static final int MENU_SIZE = 5;

    // Method to display the hotel name
    static void displayHotelName() {
        System.out.println("=========================================");
        System.out.println("           WELCOME TO DELICIA HOTEL      ");
        System.out.println("=========================================");
    }

    // Method to display the menu
    static void displayMenu() {
        System.out.println("***************");
        System.out.println(" No     Menu Item            Price (Rs)");
        System.out.println("***************");
        System.out.println(" 1      Chicken Curry        700");
        System.out.println(" 2      Mutton Curry         1000");
        System.out.println(" 3      Chicken Achari       800");
        System.out.println(" 4      Roti                 10");
        System.out.println(" 5      Chapati              15");
        System.out.println("***************");
    }

    // Method to take the user's order
    static void takeOrder(int[] no, int[] qty, String[] name, long[] price, float[] total, int n) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            System.out.print("Please enter your choice (" + (i + 1) + ") = ");
            no[i] = sc.nextInt();
            System.out.print("Enter the quantity = ");
            qty[i] = sc.nextInt();

            switch (no[i]) {
                case 1:
                    name[i] = "Chicken Curry";
                    price[i] = 700;
                    break;
                case 2:
                    name[i] = "Mutton Curry";
                    price[i] = 1000;
                    break;
                case 3:
                    name[i] = "Chicken Achari";
                    price[i] = 800;
                    break;
                case 4:
                    name[i] = "Roti";
                    price[i] = 10;
                    break;
                case 5:
                    name[i] = "Chapati";
                    price[i] = 15;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    i--; // repeat the iteration for invalid input
                    continue;
            }
            total[i] = price[i] * qty[i]; // Calculate total price for the item
        }
    }

    // Method to display the final order summary
    static void displayOrder(int[] qty, String[] name, long[] price, float[] total, int n, float jum) {
        System.out.println("***** Order Summary *****");
        System.out.printf("%5s %20s %12s %15s\n", "Qty", "Item", "Unit Price", "Total Price");
        System.out.println("**************");

        for (int i = 0; i < n; i++) {
            System.out.printf("%5d %20s %12d %15.2f\n", qty[i], name[i], price[i], total[i]);
        }

        System.out.println("**************");
        System.out.printf("Grand Total: Rs. %.2f\n", jum);
    }
}