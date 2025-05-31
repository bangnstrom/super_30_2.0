package daythree;

import java.util.Scanner;

public class Graph_Class {
    int v;
    int[] visited;
    int[][] g;

    // Method to create the graph
    public void createGraph(int nodes) {
        v = nodes;
        visited = new int[v];
        g = new int[v][v];

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print("Enter value for v" + i + " to v" + j + " (999 for infinity): ");
                g[i][j] = in.nextInt();
            }
        }
    }

    // Method to print the graph
    void printG() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(g[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Reset visited array
    public void resetVisited() {
        for (int i = 0; i < v; i++) {
            visited[i] = 0;
        }
    }

    // DFS traversal
    public void DFS(int source) {
        visited[source] = 1;
        System.out.println("V" + source);
        for (int i = 0; i < v; i++) {
            if (g[source][i] == 1 && visited[i] == 0) {
                DFS(i);
            }
        }
    }

    // BFS traversal
    public void BFS(int source) {
        int[] q = new int[v];
        int front = 0, rear = -1;

        visited[source] = 1;
        q[++rear] = source;

        while (front <= rear) {
            int element = q[front++];
            System.out.println("V" + element);

            for (int i = 0; i < v; i++) {
                if (g[element][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    q[++rear] = i;
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Graph_Class obj = new Graph_Class();
        obj.createGraph(5);
        obj.printG();

        obj.resetVisited();
        System.out.println("\nDFS Traversal:");
        obj.DFS(0);

        obj.resetVisited();
        System.out.println("\nBFS Traversal:");
        obj.BFS(0);
    }
}
