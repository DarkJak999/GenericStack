package org.academiadecodigo.genericstack;

import java.util.Objects;

/**
 * Created by codecadet on 20/10/16.
 */
public class BetterStack <T>{

    private int counter;
    private Node <T> tail;

    public BetterStack() {
        this.tail = new Node();
        counter = 0;
    }

    public void push(T obj){

        Node tempNode = new Node(obj);
        Node tempTail = tail;

        //if the stack is empty, just add at the start
        if(tempTail.getNext() == null){
            tempTail.setNext(tempNode);
            counter++;
            return;
        }

        tempNode.setNext(tempTail.getNext());
        tempTail.setNext(tempNode);
        counter++;

    }

    public T pop(){

        Node tempTail = tail;
        Node tempNode;

        if(tempTail.getNext() == null){
            return null;
        }

        tempNode = tail.getNext();
        tempTail.setNext(tempNode.getNext());
        counter--;

        return (T)tempNode.getData();
    }

    public boolean isEmpty(){
        if (counter == 0)
            return true;
        return false;
    }

    public void clear(){
        tail.setNext(null);
        counter = 0;
    }

    public int size(){
        return counter;
    }

    public T peek(){

        Node tempTail = tail.getNext();

        if(tempTail == null){
            return null;
        }

        return (T)tempTail.getData();
    }


    private class Node <T>{

        T data;
        Node next;

        public Node() {
        }

        public Node(T data) {
            this.next = null;
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
