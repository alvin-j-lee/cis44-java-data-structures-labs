import java.util.Scanner;

/*
This is the Main file of the playlist implementation. It allows the
user to make a selection from a playlist menu to add, remove,
play next songs, or display the whole playlist, or exit.
 */

public class Main {
    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        int selection;

        do {
            System.out.println("Playlist Menu: ");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            System.out.print("Enter selection: ");

            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1: // add
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();

                    playlist.addSong(new Song(title, artist));
                    break;

                case 2: // remove
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = scanner.nextLine();
                    playlist.removeSong(removeTitle);
                    break;

                case 3: // play next song
                    playlist.playNext();
                    break;

                case 4: // display playlist
                    playlist.displayPlaylist();
                    break;

                case 5: // exit playlist
                    System.out.println("Exiting playlist.");
                    break;

                default: // user did not choose 1-5.
                    System.out.println("Invalid selection.");
            }

        } while (selection != 5); // break condition is selection = 5

        scanner.close();
    }
}