package dayfour;

import java.util.Arrays;

public class sortingAlgorithms {
    void bubbleSort(int a[]) {
        for (int i = a.length - 1; i > 0; i--) {
            System.out.println("pass");
            boolean done = true;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    done = false;
                }
            }
            if (done) {
                break;
            }
        }
    }

    void selectionSort(int a[]) {
        for (int i = a.length - 1; i > 0; i--) {
            int min = a[i];
            int pos = i;
            for (int j = i + 1; j < a.length;) {
            }
        }

    }

    void insertionSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int new_element = a[i + 1]; // to be inserted
            int j = i + 1;
            while (j > 0 && a[j - 1] > new_element) {
                a[j] = a[j - 1]; // move back
                j--;
            }
            a[j] = new_element;
        }
    }

    void quickSort(int a[], int start, int end) {
        int i = start;
        int j = end;
        int pivot = start;
        while (i < j) {
            while (a[i] < a[pivot]) {
                i++;
            }
            while (a[j] > a[pivot]) {
                j++;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        if (i < end) {
            quickSort(a, i + 1, end);
        }
        if (j > start) {
            quickSort(a, start, j -  1);
        }

    }

    public static void main(String[] args) {
        sortingAlgorithms s = new sortingAlgorithms();
        int a[] = { 5, 3, 6, 2, 7, 1, 8 };
        System.out.println("\norignal array:" + Arrays.toString(a));
        s.bubbleSort(a);
        System.out.println("\nsorted array:" + Arrays.toString(a));
        int b[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("\norignal array:" + Arrays.toString(b));
        s.bubbleSort(b);
        System.out.println("\nsorted array:" + Arrays.toString(b));

    }
}
