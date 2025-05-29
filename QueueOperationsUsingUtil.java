import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class QueueOperationsUsingUtil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> Q = new LinkedList<>();

        while (true) {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Check if Empty");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int element = scanner.nextInt();
                    Q.add(element);
                    System.out.println(element + " enqueued to Q");
                    break;
                case 2:
                    if (Q.isEmpty()) {
                        System.out.println("Queue is empty! Cannot dequeue");
                    } else {
                        int removedElement = Q.remove();
                        System.out.println(removedElement + " dequeued from Q");
                    }
                    break;
                case 3:
                    if (Q.isEmpty()) {
                        System.out.println("Queue is empty! No front element");
                    } else {
                        System.out.println("Front element: " + Q.peek());
                    }
                    break;
                case 4:
                    if (Q.isEmpty()) {
                        System.out.println("Queue is empty!");
                    } else {
                        System.out.println("Queue: " + Q);
                    }
                    break;
                case 5:
                    System.out.println("Queue is " + (Q.isEmpty() ? "empty" : "not empty"));
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}