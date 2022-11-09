package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest  {

    @Test
    void testAppend() {
        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(22, artistNames, "album 1", 1);
        //assertEquals(1, dll.append(a1).album.numberOfSongs);

        Album a2 = new Album(12, artistNames, "album 2", 2);
        //assertEquals(22, dll.append(a2).album.numberOfSongs);

        Album a3 = new Album(33, artistNames, "album 3", 3);
        //assertEquals(32, dll.append(a3).album.numberOfSongs);

        dll.append(a1);
        dll.append(a2);
        dll.append(a3);


        //assertEquals(12, dll.head.album.numberOfSongs);

        System.out.print(dll.toString());
        assertEquals("22: 1 -- [Artist 1, Artist 2] -> 12: 2 -- [Artist 1, Artist 2] -> 33: 3 -- [Artist 1, Artist 2] -> NULL",dll.toString());


    }

}