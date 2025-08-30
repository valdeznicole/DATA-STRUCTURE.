/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

public class ArrayLinkedListSimulation {
    private int[] data;
    private int size;

    public ArrayLinkedListSimulation() {
        data = new int[5];
        size = 0;
    }

    public void add(int value) {
        if (size == data.length) {
            expandArray();
        }
        data[size++] = value;
    }

    public int poll() {
        if (size == 0) return -1;
        int first = data[0];
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return first;
    }

    public int peek() {
        if (size == 0) return -1;
        return data[0];
    }

    public int pop() {
        if (size == 0) return -1;
        return data[--size];
    }

    private void expandArray() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void printElements() {
        System.out.print("Elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayLinkedListSimulation obj = new ArrayLinkedListSimulation();

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            obj.add(sc.nextInt());
        }

        obj.printElements();

        // Directly call methods without prefixing with list.
        int firstElement = obj.peek();
        System.out.println("Peek (first element): " + firstElement);

        int removedFirst = obj.poll();
        System.out.println("Poll (removed first): " + removedFirst);
        obj.printElements();

        int removedLast = obj.pop();
        System.out.println("Pop (removed last): " + removedLast);
        obj.printElements();

        sc.close();
    }
}
