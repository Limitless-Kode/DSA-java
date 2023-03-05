package com.claver.linked.list;

import java.util.NoSuchElementException;

public class LinkedList<T> {
     private class Node {
        private final T value;
        private Node next;


        public Node(T value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;
    public void addFirst(T value){
        var node = new Node(value);
        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(T value){
        var node = new Node(value);
        if(isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last){
            first = last = null;
            return;
        }else{
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast(){
        if(isEmpty()) throw new NoSuchElementException();

        if(first == last){
            first = last = null;
            return;
        }else{
            var previousNode = getPreviousNode(last);
            previousNode.next = null;
            last = previousNode;
        }
        size--;
    }


    public boolean contains(T value){
        return indexOf(value) != -1;
//        Node currentNode = first;
//        while (currentNode != null){
//            if(currentNode.value == value) return true;
//            currentNode = currentNode.next;
//        }
//        return false;
    }

    public int indexOf(T value){
        Node currentNode = first;
        int index = 0;
        while (true){
            if(currentNode.value == value) return index;
            if(currentNode.next == null)  break;
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public T[] toArray(){
        T[] array = (T[]) new Object[size];
        var currentNode = first;
        int index = 0;
        while(currentNode != null){
            array[index++] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

    public void reverse(){
        Node prev = null;
        var currentNode = first;
        Node next;
        while(currentNode != null){
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        first = prev;
    }

    private Node getPreviousNode(Node node){
        Node previousNode = node;
        Node currentNode = first;
        if(first == node) return null;

        while(currentNode != null){
            if(currentNode == node) return previousNode;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return previousNode;
    }

    public T getKthNodeFromEnd(int k){
        if(k > size) throw new IllegalArgumentException();
        if(isEmpty()) throw new IllegalArgumentException();

        Node startNode = first;
        Node endNode = null;
        Node currentNode = first;
        int counter = 0;
        while (currentNode != null){
            if(counter == k) endNode = currentNode;
            if(endNode != null){
               startNode = startNode.next;
               endNode = endNode.next;
               if(endNode == null){
                   break;
               }
            }
            currentNode = currentNode.next;
            counter++;
        }
        return startNode.value;
    }
}
