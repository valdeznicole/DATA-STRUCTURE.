/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spotify;
import java.util.*;
/**
 *
 * @author Iam
 */
public class Spotify {

 



    // Current playlist
    private ArrayList<String> playlist = new ArrayList<>();

    // Undo and Redo stacks (store snapshots of playlist states)
    private Stack<ArrayList<String>> undoStack = new Stack<>();
    private Stack<ArrayList<String>> redoStack = new Stack<>();

    // Deep copy method (so stack saves snapshots, not references)
    private ArrayList<String> copyPlaylist(ArrayList<String> original) {
        return new ArrayList<>(original);
    }

    // Add song
    public void addSong(String song) {
        undoStack.push(copyPlaylist(playlist)); // save state before change
        redoStack.clear(); // clear redo history
        playlist.add(song);
        System.out.println("✅ Added: " + song);
    }

    // Remove last song
    public void removeSong() {
        if (playlist.isEmpty()) {
            System.out.println("⚠️ Playlist is empty. Nothing to remove.");
            return;
        }
        undoStack.push(copyPlaylist(playlist));
        redoStack.clear();
        String removed = playlist.remove(playlist.size() - 1);
        System.out.println("🗑 Removed: " + removed);
    }

    // Undo last action
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("⚠️ Nothing to undo.");
            return;
        }
        redoStack.push(copyPlaylist(playlist)); // save current state
        playlist = undoStack.pop(); // restore previous
        System.out.println("↩️ Undo successful.");
    }

    // Redo action
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("⚠️ Nothing to redo.");
            return;
        }
        undoStack.push(copyPlaylist(playlist)); // save current state
        playlist = redoStack.pop();
        System.out.println("↪️ Redo successful.");
    }

    // View playlist
    public void viewPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("🎵 Playlist is empty.");
        } else {
            System.out.println("🎶 Current Playlist:");
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }

    // Menu
    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Spotify Playlist Menu =====");
            System.out.println("1. Add song");
            System.out.println("2. Remove last song");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. View playlist");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    String song = sc.nextLine();
                    addSong(song);
                    break;
                case 2:
                    removeSong();
                    break;
                case 3:
                    undo();
                    break;
                case 4:
                    redo();
                    break;
                case 5:
                    viewPlaylist();
                    break;
                case 6:
                    System.out.println("👋 Thank you for listening... Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    // Main method
    public static void main(String[] args) {
        Spotify app = new Spotify();
        app.start();
    }
}
