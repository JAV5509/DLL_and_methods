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

    @Test
    void testDelete(){

        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(11, artistNames, "album 1", 1);
        dll.append(a1);

        Album a2 = new Album(22, artistNames, "album 2", 2);
        dll.append(a2);

        Album a3 = new Album(33, artistNames, "album 3", 3);
        dll.append(a3);

        Album a4 = new Album(44, artistNames, "album 44", 44);
        dll.append(a4);

        Album a5 = new Album(88,artistNames, "album 5", 11);
        dll.append(a5);

        Album a6 = new Album(99, artistNames, "album huh", 8);
        dll.append(a6);

        Album a7 = new Album(17, artistNames, "album huh", 80);
        dll.append(a7);

        Album a8 = new Album(79, artistNames, "album huh", 9);
        dll.append(a8);

        Album a9 = new Album(56, artistNames, "album huh", 78);
        dll.append(a9);


        System.out.println(dll.toString());
        dll.delete(0);
        assertEquals("22: 2 -- [Artist 1, Artist 2] -> 33: 3 -- [Artist 1, Artist 2] -> 44: 44 -- [Artist 1, Artist 2] -> 88: 11 -- [Artist 1, Artist 2] -> 99: 8 -- [Artist 1, Artist 2] -> 17: 80 -- [Artist 1, Artist 2] -> 79: 9 -- [Artist 1, Artist 2] -> 56: 78 -- [Artist 1, Artist 2] -> NULL",dll.toString());
        dll.delete(4);
        System.out.println(dll.toString());
        assertEquals("22: 2 -- [Artist 1, Artist 2] -> 33: 3 -- [Artist 1, Artist 2] -> 44: 44 -- [Artist 1, Artist 2] -> 88: 11 -- [Artist 1, Artist 2] -> 17: 80 -- [Artist 1, Artist 2] -> 79: 9 -- [Artist 1, Artist 2] -> 56: 78 -- [Artist 1, Artist 2] -> NULL",dll.toString());


    }

    @Test
    void testGetIndex() {

        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(11, artistNames, "album 1", 1);
        dll.append(a1);

        Album a2 = new Album(22, artistNames, "album 2", 2);
        dll.append(a2);

        Album a3 = new Album(33, artistNames, "album 3", 3);
        dll.append(a3);

        Album a4 = new Album(44, artistNames, "album 44", 44);
        dll.append(a4);

        Album a5 = new Album(88,artistNames, "album 5", 11);
        dll.append(a5);

        Album a6 = new Album(99, artistNames, "album huh", 8);
        dll.append(a6);

        Album a7 = new Album(17, artistNames, "album huh", 80);
        dll.append(a7);

        Album a8 = new Album(79, artistNames, "album huh", 9);
        dll.append(a8);

        Album a9 = new Album(56, artistNames, "album huh", 78);
        dll.append(a9);

        Album a10 = new Album(16, artistNames, "album yupp", 18);



        System.out.println(dll.toString());

        System.out.println(dll.getIndex(a1));
        assertEquals(0, dll.getIndex(a1));
        System.out.println(dll.getIndex(a4));
        assertEquals(3, dll.getIndex(a4));
        //WHY IS MY EDGE CASE NOT WORKING??
        //
        System.out.println(dll.getIndex(a10));
        assertEquals(-1,dll.getIndex(a10));




    }

    @Test
    void testInsert() {

        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(11, artistNames, "album 1", 1);
        dll.append(a1);

        Album a2 = new Album(22, artistNames, "album 2", 2);
        dll.append(a2);

        Album a3 = new Album(33, artistNames, "album 3", 3);
        dll.append(a3);

        Album a4 = new Album(44, artistNames, "album 44", 44);
        dll.append(a4);

        Album a5 = new Album(88,artistNames, "album 5", 11);
        dll.append(a5);

        Album a6 = new Album(72,artistNames, "album 5", 11);

        System.out.println(dll.toString());
        dll.insert(2,a6);
        System.out.println(dll.toString());
        assertEquals("11: 1 -- [Artist 1, Artist 2] -> 22: 2 -- [Artist 1, Artist 2] -> 72: 11 -- [Artist 1, Artist 2] -> 33: 3 -- [Artist 1, Artist 2] -> 44: 44 -- [Artist 1, Artist 2] -> 88: 11 -- [Artist 1, Artist 2] -> NULL", dll.toString());

    }

    @Test
    void testShuffle() {

        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(11, artistNames, "album 1", 1);
        dll.append(a1);

        Album a2 = new Album(22, artistNames, "album 2", 2);
        dll.append(a2);

        Album a3 = new Album(33, artistNames, "album 3", 3);
        dll.append(a3);

        Album a4 = new Album(44, artistNames, "album 44", 44);
        dll.append(a4);

        Album a5 = new Album(88,artistNames, "album 5", 11);
        dll.append(a5);

        Album a6 = new Album(72,artistNames, "album 5", 11);

        System.out.println(dll.toString());
        System.out.println(dll.shuffle());

    }

    @Test
    void testpartition(){

        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(11, artistNames, "album 1", 1);
        dll.append(a1);

        Album a2 = new Album(22, artistNames, "album 2", 2);
        dll.append(a2);

        Album a3 = new Album(33, artistNames, "album 3", 3);
        dll.append(a3);

        Album a4 = new Album(44, artistNames, "album 44", 44);
        dll.append(a4);

        Album a5 = new Album(88,artistNames, "album 5", 11);
        dll.append(a5);

        Album a6 = new Album(99, artistNames, "album huh", 8);
        dll.append(a6);

        Album a7 = new Album(17, artistNames, "album huh", 80);
        dll.append(a7);

        Album a8 = new Album(79, artistNames, "album huh", 9);
        dll.append(a8);

        Album a9 = new Album(56, artistNames, "album huh", 78);
        dll.append(a9);


        System.out.println(dll.toString());

        System.out.println(dll.partition(a6).toString());





    }


    @Test
    void testtoString() {

        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(11, artistNames, "album 1", 1);
        dll.append(a1);

        Album a2 = new Album(22, artistNames, "album 2", 2);
        dll.append(a2);

        Album a3 = new Album(33, artistNames, "album 3", 3);
        dll.append(a3);

        Album a4 = new Album(44, artistNames, "album 44", 44);
        dll.append(a4);

        Album a5 = new Album(88,artistNames, "album 5", 11);
        dll.append(a5);

        System.out.println(dll.toString());
        assertEquals("11: 1 -- [Artist 1, Artist 2] -> 22: 2 -- [Artist 1, Artist 2] -> 33: 3 -- [Artist 1, Artist 2] -> 44: 44 -- [Artist 1, Artist 2] -> 88: 11 -- [Artist 1, Artist 2] -> NULL", dll.toString());


    }

}