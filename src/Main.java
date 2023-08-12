import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Album arijitAlbum = new Album("Arijit Singh", "Arijit's Album");
        Album alanAlbum = new Album("Alan Walker", "Walker's Album");

        arijitAlbum.addSongToAlbum("Kesariya", 3.5);
        arijitAlbum.addSongToAlbum("Tum Kya Mile", 2.6);
        arijitAlbum.addSongToAlbum("Lal Ishq", 3.9);

        alanAlbum.addSongToAlbum("Faded", 3.5);
        alanAlbum.addSongToAlbum("Alone", 4.1);
        alanAlbum.addSongToAlbum("Darkside", 2.6);

        LinkedList<Song> myPlaylist = new LinkedList<>();

        System.out.println(arijitAlbum.addToPlayListFromAlbum("Kesariya", myPlaylist));
        System.out.println(arijitAlbum.addToPlayListFromAlbum(2, myPlaylist));
        System.out.println(arijitAlbum.addToPlayListFromAlbum(5, myPlaylist));

        System.out.println(alanAlbum.addToPlayListFromAlbum("Alone", myPlaylist));
        System.out.println(alanAlbum.addToPlayListFromAlbum(3, myPlaylist));

//        for(Song song: myPlaylist) {
//            System.out.println(song);
//        }

        play(myPlaylist);

    }
    private static void play(LinkedList<Song> myPlayList) {

        if(myPlayList.size() == 0) {
            System.out.println("Your PlayLst is Empty");
            return;
        }
        ListIterator<Song> itr = myPlayList.listIterator();
        System.out.println("Now Playing: " + itr.next());
        boolean wasNext = true;

        Scanner sc = new Scanner(System.in);
        printMenu();

        boolean quit = false;
        while(!quit) {
            System.out.println("Please Enter your choice");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    printMenu();
                    break;
                case 2:   //next
                    if(wasNext == false) {       //it mean coming form prev
                        itr.next();
                        wasNext = true;
                    }
                    if(!itr.hasNext()) {
                        System.out.println("You have reached the end of playlist");
                    }
                    else {
                        System.out.println("Currently Playing: " +itr.next());
                        wasNext = true;
                    }
                    break;
                case 3:    //previous
                    if(wasNext == true) {    //it mean coming from next
                        itr.previous();
                        wasNext = false;
                    }
                    if(!itr.hasPrevious()) {
                        System.out.println("Yor are at the starting of the playlist");
                    }
                    else {
                        System.out.println("Currently Playing: " +itr.previous());
                        wasNext = false;
                    }
                    break;
                case 4:
                    if(wasNext == true) {
                        System.out.println("Currently Playing: " +itr.previous());
                        wasNext = false;
                    }
                    else {
                        System.out.println("Currently Playing: " +itr.next());
                        wasNext = true;
                    }
                    break;
                case 5:    //delete a current song from playlist    you have to implement on your own
                    if (wasNext == true) {
                        // Delete the song that was played last (next song)
                        if (itr.hasPrevious()) {
                            System.out.println("Deleted: " + itr.previous());
                            itr.remove();
                        } else {
                            System.out.println("No song to delete.");
                        }
                    }
                    else {
                        // Delete the song that was played last (previous song)
                        if (itr.hasNext()) {
                            System.out.println("Deleted: " + itr.next());
                            itr.remove();
                        } else {
                            System.out.println("No song to delete.");
                        }
                    }
                    break;
                case 6:
                    printSongs(myPlayList);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice, Please select again");
            }
        }
    }

    private static void printSongs(LinkedList<Song> myPlayList) {

        for(Song song : myPlayList) {
            System.out.println(song);
        }
    }

    private static void printMenu() {

        System.out.println("1. Show the Menu Again");
        System.out.println("2. Play next Song");
        System.out.println("3. Play previous song");
        System.out.println("4. Play current song again");
        System.out.println("5. Delete current song from playlist");
        System.out.println("6. Print all the songs in playlist");
        System.out.println("7. Quit Application");
        System.out.println();
    }
}