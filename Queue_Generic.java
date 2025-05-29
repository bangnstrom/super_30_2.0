// Generate Binary Numbers from 1 to N 
// Problem: Given a positive integer N, generate binary numbers 
// from 1 to N using a queue. 
// Explanation:  
// We can use a queue to generate binary numbers in order. 
// 1. Enqueue "1" into the queue. 
// 2. While N is greater than 0: 
// ● Dequeue a binary number from the queue. 
// ● Print the dequeued number. 
// ● Enqueue the dequeued number appended with "0" and "1" 
// into the queue. 
// ● Decrement N. 
// Input Sample: 
// N = 5 
// Output Sample: 
// 1 10 11 100 101

import java.util.Queue;
import java.util.LinkedList;

public class Queue_Generic {

    public void binaryy(int e) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 1; i < e; i++) {
            String temp = queue.poll();
            System.out.println(temp + "");
            queue.add(temp + 0);

            queue.add(temp + 1);
        }

    }

    public static void main(String[] args) {
        // Add elements to the queue
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // // Peek at the front element
        // System.out.println("Front element: " + queue.peek()); //10
        // // Remove an element
        // System.out.println("Removed element: " + queue.poll());
        // // 10
        // // Check size of the queue
        // System.out.println("Size of queue: " + queue.size()); //2

    }
}
