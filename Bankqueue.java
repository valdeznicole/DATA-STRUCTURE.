/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankqueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *
 * @author Iam
 */
public class Bankqueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<customer> queue = new LinkedList<>();
        int customerCount = 0;
        boolean running = true;

        while (running) {
            System.out.println("\n--- Bank Queue System ---");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: // Add customer
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    customerCount++;
                    customer newCustomer = new customer(name, customerCount);
                    queue.add(newCustomer);
                    System.out.println("Customer added: " + newCustomer);
                    break;

                case 2: // Serve customer
                    if (queue.isEmpty()) {
                        System.out.println("No customers in queue.");
                    } else {
                        customer served = queue.poll();
                        System.out.println("Serving customer: " + served);
                    }
                    break;

                case 3: // View queue
                    if (queue.isEmpty()) {
                        System.out.println("The queue is empty.");
                    } else {
                        System.out.println("Current queue:");
                        for (customer c : queue) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 4: // Exit
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
