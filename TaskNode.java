/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Iam
 */
public class TaskNode {
   
    String title;
    TaskNode next;

    public TaskNode(String title) {
        this.title = title;
        this.next = null;
    }
}

// Singly Linked List for To-Do List
class ToDoList {
    private TaskNode head;

    // Add task at the end
    public void addTask(String title) {
        TaskNode newNode = new TaskNode(title);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("\n✅ Task added!");
    }

    // Delete task by title
    public void deleteTask(String title) {
        if (head == null) {
            System.out.println("\n⚠️ List is empty. Nothing to delete.");
            return;
        }

        // If head is the one to delete
        if (head.title.equalsIgnoreCase(title)) {
            head = head.next;
            System.out.println("\n🗑 Task deleted!");
            return;
        }

        // Traverse and find
        TaskNode current = head;
        while (current.next != null && !current.next.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("\n❌ Task not found.");
        } else {
            current.next = current.next.next;
            System.out.println("\n🗑 Task deleted!");
        }
    }

    // Print all tasks
    public void printTasks() {
        if (head == null) {
            System.out.println("\n📭 No tasks available.");
            return;
        }

        System.out.println("\n📝 Your Tasks:");
        TaskNode current = head;
        while (current != null) {
            System.out.println("- " + current.title);
            current = current.next;
        }
    }

    // Search if task exists
    public boolean contains(String title) {
        TaskNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
}
