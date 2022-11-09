package com.company;

public class Node<T> {

    Album album;
    Node<T> next;
    Node<T> previous;

    public Node(Album album) {
        this.album = album;
        this.next = null;
        this.previous = null;
    }

    @Override
    public String toString() {
        return album.toString();
    }
}
