/*
This is my Playlist class, implemented using a singly linked list.

It manages a collection of Song objects, allows Songs to be added, removed
displayed, and played in sequence.

Despite being a singly linked list, it allows for circular listening, as in
the playlist will loop to the beginning after reaching the end.
 */

public class Playlist {

    private static class Node {
        Song song;
        Node next;

        // Node constructor
        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    // playlist constructor
    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    // Adds songs to the end of the playlist
    public void addSong(Song song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
        System.out.println("Song added.");
    }

    // This removes song based on title.
    public void removeSong(String title) {

        // Lets user know if the playlist is empty.
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        // Case 1: Remove head
        if (head.song.getTitle().equalsIgnoreCase(title)) {
            head = head.next;

            if (head == null) {  // List became empty
                tail = null;
                currentNode = null;
            }

            size--;
            System.out.println("Song removed.");
            return;
        }

        // Case 2: Remove non-head
        Node current = head;

        while (current.next != null &&
                !current.next.song.getTitle().equalsIgnoreCase(title)) {
            current = current.next;
        }

        // In the event that the input song name isn't in the playlist:
        if (current.next == null) {
            System.out.println("Song not found.");
            return;
        }

        // Case 3: Removing tail
        if (current.next == tail) {
            tail = current;
        }

        current.next = current.next.next;
        size--;
        System.out.println("Song removed.");
    }

    // Play the next song, circling to the start if the end is reached.
    public void playNext() {

        // if the playlist is empty:
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (currentNode == null) {
            currentNode = head;
        } else {
            currentNode = currentNode.next;
            if (currentNode == null) {
                currentNode = head; // Circle back to the head
            }
        }

        System.out.println("Now Playing: " + currentNode.song);
    }

    // Display entire playlist
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node temp = head;
        System.out.println("Playlist:");

        while (temp != null) {
            System.out.println(temp.song);
            temp = temp.next;
        }

        System.out.println("Total number of songs: " + size);
    }
}