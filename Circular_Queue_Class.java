public class Circular_Queue_Class {
    int front, rear, MaxSize, queue[], count;

    public void create_Queue(int size) {
        front = 0;
        rear = -1;
        count = 0;
        MaxSize = size;
        queue = new int[MaxSize];
    }

    public void Enqueue(int e) {
        rear = (rear + 1) % MaxSize;
        count++;
        queue[rear] = e;
    }

    public boolean is_Full() {
        if (count == MaxSize)
            return true;
        else
            return false;
    }

    public int Dequeue() {
        int temp = queue[front];
        front = (front + 1) % MaxSize;
        count--;
        return (temp);
    }

    public boolean is_Empty() {
        if (count == 0)
            return true;
        else
            return false;
    }

    public void print_Queue() {

        if (!is_Empty()) {
            for (int i = front; i <= count; i++) {
                System.out.println(queue[i]);

                i = (i + 1) % MaxSize;
            }
        } else {
            System.out.println("queue is empty");
        }
    }
}