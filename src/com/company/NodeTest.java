package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    public void Nodetest() {

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album old_1 = new Album(2324,artistNames, "The Motions", 8);
        Node new_1 = new Node(old_1);

        System.out.println(new_1.toString());


    }
}