package OOP_review;
/*
Write a program that uses a linked list to create a playlist of songs.
A Song is an object that has a title and an artist. The playlist program can allow users to
add Songs to the playlist, can display the current song that’s being played, or skip to the next song.
 */
import java.util.*;
public class songs_2 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtFront(new Song("Title a", "Artist a"));
        list.addAtFront(new Song("Title b", "Artist b"));
        list.addAtFront(new Song("Title c", "Artist c"));
        System.out.println(list.toString());

        list.loop();


    }
}
