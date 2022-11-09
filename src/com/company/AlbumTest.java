package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AlbumTest {

    @Test
    void testAlbum(){


        ArrayList<String> artistNames = new ArrayList<>();

        artistNames.add("Artist 1");
        artistNames.add("Artist 2");
        artistNames.add("Artist 3");

        Album tester_1 = new Album(2324,artistNames, "The Motions", 8);

        Album tester_2 = new Album();

        //testing the constructor

        System.out.println(tester_1.toString());

        System.out.println(tester_2.toString());

        assertEquals("2324: 8 -- [Artist 1, Artist 2, Artist 3]", tester_1.toString());


    }

}