class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node head; 

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Pushed " + data + " onto the stack.");
    }

    public int pop() {
        if (head == null) {
            System.out.println("Stack Underflow! Cannot pop from an empty stack.");
            return -1; 
        }
        int poppedData = head.data;
        head = head.next;
        System.out.println("Popped " + poppedData + " from the stack.");
        return poppedData;
    }

    // Peek operation
    public int peek() {
        if (head == null) {
            System.out.println("Stack is empty. Nothing to peek.");
            return -1;
        }
        System.out.println("Top of stack is " + head.data);
        return head.data;
    }

    // Print stack
    public void printStack() {
        if (head == null) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements from top to bottom:");
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

// Main class to test the Stack
public class LinkedListStack {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(5);
        stack.push(15);
        stack.push(25);

        stack.printStack();

        stack.peek();
        stack.pop();

        stack.printStack();
    }
}
