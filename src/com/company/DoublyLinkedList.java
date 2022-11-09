package com.company;


public class DoublyLinkedList <T extends Comparable<T>> {

    protected Node head;
    protected Node tail;


    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }


    public Node append(Album album) {

        //create a new node
        Node toAppend = new Node(album);

        //check if list is empty
        if (head == null) {
            head = toAppend;
            tail = toAppend;
        }

        //if list length is one or more than one
        else {
            toAppend.previous = tail;
            tail.next = toAppend;
            tail = tail.next;
        }


        //return node
        return toAppend;


    }
/*
    public Node delete(int location) throws IllegalArgumentException{

    }

 */


    public int getIndex(Album album) {

        Node found = head;
        int pos = -1;

        //for cases in which the DLL is null
        if (found == null) {

            System.out.println("Im sorry but you must add nodes!");

        }
        //iterates through the linked list and evertime it iterates through a node the pos increase
        //pos is storing the iterations, which is the index
        while (found.album != album
                && found.next != null) {

            found = found.next;//previous;
            //used to count the nodes interated through and calculate index
            pos++;

        }
        if (found.album != album)
            return -1;
        // If the integer present in
        // the doubly linked list
        return (pos + 1);


    }





    @Override
    public String toString() {

        // get a current pointer
        Node toPrint = this.head;

        // get a string builder
        StringBuilder stringBuilder = new StringBuilder();

        // loop through all the nodes
        while (toPrint != null) {

            // append the content of the string to the builder
            stringBuilder.append(toPrint.album.toString());
            stringBuilder.append(" -> ");

            // advance the pointer
            toPrint = toPrint.next;
        }

        // append null
        stringBuilder.append("NULL");

        // return the result
        return stringBuilder.toString();
    }
}
