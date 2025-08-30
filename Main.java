/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import java.util.Scanner;
/**
 *
 * @author Iam
 */
public class Main {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ToDoList todo = new ToDoList();
        int choice;

        do {
            System.out.println("\n===== To-Do List Menu =====");
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. View all tasks");
            System.out.println("4. Search task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    todo.addTask(title);
                    break;
                case 2:
                    System.out.print("Enter task title to delete: ");
                    String delTitle = sc.nextLine();
                    todo.deleteTask(delTitle);
                    break;
                case 3:
                    todo.printTasks();
                    break;
                case 4:
                    System.out.print("Enter task title to search: ");
                    String searchTitle = sc.nextLine();
                    if (todo.contains(searchTitle)) {
                        System.out.println("\nTask found!");
                    } else {
                        System.out.println("\n Task not found.");
                    }
                    break;
                case 5:
                    System.out.println("\n?Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("\n Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
    

