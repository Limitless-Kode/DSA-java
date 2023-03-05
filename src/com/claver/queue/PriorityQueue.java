package com.claver.queue;

import com.claver.array.Array;

import java.util.Stack;

public class PriorityQueue {
    Array array;
    int front = 0;
    int rear = 0;
    int size;
    int[] list;
    public PriorityQueue(int size){
        array = new Array(size);
        this.size = size;
    }

    public void enqueue(int value){
        list[rear] = value;
        rear++;
    }

    public int dequeue(){
        front++;
        return array.pop();
    }
}
