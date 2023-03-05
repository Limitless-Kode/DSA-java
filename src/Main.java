import com.claver.array.Array;
import com.claver.linked.list.LinkedList;
import com.claver.queue.ArrayQueue;
import com.claver.queue.PriorityQueue;
import com.claver.queue.StackQueue;
import com.claver.stack.StringReverser;
import com.claver.stack.SynthaxChecker;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayDeque<>();
        PriorityQueue queue = new PriorityQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
    }

    public static void reverse(Queue<Integer> queue){
        Array array = new Array(queue.size());

        while (!queue.isEmpty()){
            array.insert(queue.remove());
        }

        int arraySize = array.size();
        for (int i = 0; i < arraySize; i++){
            queue.add(array.pop());
        }

        System.out.println(queue);
    }
}