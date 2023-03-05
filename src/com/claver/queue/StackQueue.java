package com.claver.queue;

import java.util.Stack;

public class StackQueue {
    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> reversed = new Stack<>();
    public void enqueue(int value){
        stack.push(value);
    }

    public int dequeue(){
        unpackToReversedStack();

        return reversed.pop();
    }

    public boolean isEmpty(){
        return stack.isEmpty() && reversed.empty();
    }

    public int peek(){
        unpackToReversedStack();
        return reversed.peek();
    }

    private void unpackToReversedStack() {
        if(isEmpty()) throw new IllegalStateException();
        if(reversed.empty()){
            while(!stack.empty()){
                reversed.push(stack.pop());
            }
        }
    }

}
