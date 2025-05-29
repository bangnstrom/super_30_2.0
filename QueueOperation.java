import java.util.Scanner;


public class QueueOperation {
    private int q[];
    private int maxSize, front, rear;

    // Constructor to initialize the queue
    public QueueOperation(int size) {
        maxSize = size;
        q = new int[maxSize];
        front = 0; // Points to the front of the queue
        rear = -1; // Points to the last element in the queue
    }

    // Enqueue: inserts an element at the rear
    public void enqueue(int e) {
        if (isFull()) {
            System.out.println("Queue is full, cannot insert more data.");
        } else {
            q[++rear] = e;
            System.out.println(e + " enqueued.");
        }
    }

    // Dequeue: removes and returns the front element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, nothing to dequeue.");
            return -1; // Return -1 to indicate empty queue
        } else {
            int temp = q[front++];
            // Reset front and rear if queue becomes empty
            if (front > rear) {
                front = 0;
                rear = -1;
            }
            System.out.println(temp + " dequeued.");
            return temp;
        }
    }

    // isFull: checks if the queue is full
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // isEmpty: checks if the queue is empty
    public boolean isEmpty() {
        if (rear < front) {
            System.out.println("Queue is empty.");
            return true;
        } else {
            System.out.println("Queue is not empty.");
            return false;
        }
    }

    // Peek: returns the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return q[front];
    }

    // Print: displays the queue in FIFO order
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, nothing to print.");
        } else {
            System.out.println("Queue elements (front to rear):");
            for (int i = front; i <= rear; i++) {
                System.out.print(q[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method with menu-driven interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        QueueOperation queue = new QueueOperation(size);

        while (true) {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Check if Full");
            System.out.println("6. Print Queue");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    int dequeued = queue.dequeue();
                    if (dequeued != -1) {
                        System.out.println("Dequeued element: " + dequeued);
                    }
                    break;
                case 3:
                    int frontElement = queue.peek();
                    if (frontElement != -1) {
                        System.out.println("Front element: " + frontElement);
                    }
                    break;
                case 4:
                    queue.isEmpty();
                    break;
                case 5:
                    if (queue.isFull()) {
                        System.out.println("Queue is full.");
                    } else {
                        System.out.println("Queue is not full.");
                    }
                    break;
                case 6:
                    queue.printQueue();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}