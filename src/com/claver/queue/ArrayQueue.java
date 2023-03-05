package com.claver.queue;

import javax.naming.PartialResultException;
import java.awt.font.ShapeGraphicAttribute;
import java.util.Arrays;

public class ArrayQueue {
    public int front = 0;
    public int rear = 0;
    int size;
    int count = 0;
    int[] list;
    public ArrayQueue(int size){
        this.size = size;
        list = new int[size];
    }

    public void enqueue(int value){
        if(count == list.length) throw new IllegalStateException();
        list[rear] = value;
        rear = (rear + 1) % list.length;
        count++;
    }

    public int dequeue(){
        int value = list[front];
        list[front] = 0;
        front = (front + 1) % list.length;
        count--;
        return value;
    }

    public int peek(){
        return list[rear];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == size;
    }

    @Override
    public String toString(){
        return Arrays.toString(list);
    }
}
