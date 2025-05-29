import java.util.Scanner;


public class Sliding_Window {
    static void Sliding_Window(int queue[], int window_size) {
        for (int i = 1; i <= queue.length -window_size; i++) {

            int min = queue[i];
          for(int j=1;j<i+window_size;j++){
            if(queue[j]<min)
            min= queue[j];
          }
         Arrays.stream(i,i+window_size);
          System.out.println(min+"min");
        }
    }

    static void print_Binary(int N) {
        int queue[] = { 12, 2, 55, 3, 88, 9, 33, 77, 99, 22 };
        Scanner in = new Scanner(System.in);
        int window_size;
        System.out.println("Enter Window_Size:");
        window_size = in.nextInt();
        Sliding_Window(queue, window_size);
    }
}