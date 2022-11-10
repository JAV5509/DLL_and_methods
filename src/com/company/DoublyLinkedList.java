package com.company;


import java.util.ArrayList;
import java.util.Collections;

public class DoublyLinkedList <T extends Comparable<T>> {

    protected Node head;
    protected Node tail;

    int counta = 0;

    String noNodeerror = "No nodes, please add nodes";


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

        counta++;

        //return node
        return toAppend;


    }

    public void delete(int location) throws IllegalArgumentException {

        int counter = 1;

        int i;

        // Error if the head is null
        if (head == null)
            throw new IllegalArgumentException("Sorry this is out of bounds");

        //If the index entered is less than 0, then throw the exception error
        if (location < 0)
            throw new IllegalArgumentException("Sorry this is out of bounds");

        // if the location enter is large than the number of nodes
        if (location > counta)
            throw new IllegalArgumentException("Sorry this is out of bounds");

        //if there are greater than 0 nodes and location is equal to 0
        int counterz = 0;

        if (location == 0) {
            //head value is updated
            head = head.next;
            //if the head node is not null, traers
            if (head != null) {

                head.previous = null;

            }

            if (counta == 2) {

                tail = head;

            }

            counterz = counta - 1;
        } else if (location == counterz) {

            tail = tail.previous;

            tail.next = null;

        } else {
            //create a duplicate node of the head
            Node<T> temper = head;

            //iterate up to the index of the given location
            for (int j = 1; j < location; j++) {

                //traverse through the duplicate node
                temper = temper.next;

            }

            temper.next = temper.next.next;

            //once you hit the end of traversing (null)
            if (temper.next == null) {

                tail = temper;

            } else {

                temper.next.previous = temper;
            }
        }
        //decrease the value of count to ensure the updated number of nodes is correct.
        counta--;

    }




    public int getIndex(Album album) {

        Node found = head;
        int pos = -1;

        //for cases in which the DLL is null
        if (found == null) {

            System.out.println("Im sorry but you must add nodes!");

        }
        //traverses through the doubly linked list
        while (found.album != album
                && found.next != null) {

            found = found.next;//reassign the value of what is really head
            //used to count the nodes interated through and calculate index
            pos++;



        }
        //if the given object is not presented in the doubly linked list then return -1
        if (found.album != album)
            return -1;

        // If the integer present in
        // the doubly linked list
        return (pos + 1);


    }

    public void insert(int location, Album album) throws IllegalArgumentException{

        Node new1 = new Node(album);

        //Edge cases for out of bounds input
        if(location> counta){
            System.out.println("Not within bounds");
        }

        if(location<0){
            System.out.println("Not within bounds");
        }

        if(head==null){
            System.out.println("Not within bounds");
        }
        //for instances in which the person wants to append to the head
        if(location == 0 && head != null){

            new1.next = head; //assigns new node as the head

            new1.previous = null; //previous variable of the node is null considering it is the new head

            head.previous = new1;

            head = new1;
        }


        int size = counta;

        if (location == size){

            tail.next = new1;

            tail.previous = tail.previous;

            new1 = tail;

            new1.next = null;

            new1.previous = tail;
        }

        else {
            Node temp = this.head;

            int i=1;

            while(i<location){

                temp = temp.next;
                i++;
            }

            new1.next = temp.next;

            new1.previous = temp;

            temp.next = new1;

            new1.next.previous = new1;
        }

        counta++;
    }

    public DoublyLinkedList<T> shuffle() {

        ArrayList<Album> shuffledDll = new ArrayList<>();

        DoublyLinkedList newDll = new DoublyLinkedList();

        Node tempJawn = head;

        if( tempJawn== null){
            System.out.print(noNodeerror);
        }

        else {
            //traverse through the dll
            while(tempJawn != null){
                //append the current node that is being traverses
                shuffledDll.add(tempJawn.album);

                tempJawn = tempJawn.next;
            }
            //iteration that uses the swap package
            for(int j=0; j< shuffledDll.size()- shuffledDll.size()%2; j =j +2){

                Collections.swap(shuffledDll,j,j+1);
            }

            tempJawn = this.head;

            for (int i=0; i<shuffledDll.size(); i++){

                //tempJawn.album = shuffledDll.get(i);
                //tempJawn = tempJawn.next;

                newDll.append(shuffledDll.get(i));
            }
        }

        return newDll;
    }



    public DoublyLinkedList<Album> partition(Album album) {

        DoublyLinkedList partitioned = new DoublyLinkedList();
         Node temp = this.head;

         //int count=0;

         //int albumNo = album.numberOfSongs;



         if(temp== null) System.out.println(noNodeerror);

         else {
             while (temp != null) {
                 {

                     if (temp.album.numberOfSongs>=album.numberOfSongs){
                         partitioned.append(temp.album);

                     }

                     temp = temp.next;


                    /*
                     while(temp!= null)
                         temp = temp.next;
                         if(temp==null){
                         break;

                     */


                     // }

                 }
                 //temp = temp.next;

             }


             //int index = partitioned.getIndex(album);



        /*for(int i=0; i<index;i++){

            Node tempNode = partitioned.head;
             partitioned.delete(i);

             tempNode = tempNode.next;


         }

         */



         }

        return partitioned;


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
