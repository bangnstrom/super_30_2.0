import java.util.Stack;
import java.util.Scanner;

public class int_to_bin {
    public static void main(String[] arg) {
        Stack<Integer> s = new Stack<>();

        Scanner in = new Scanner(System.in);
        System.out.println("enter the number");
        int I = in.nextInt();
        System.out.print("the converted "+I+" of binary is ");
        while (I != 0) {
            int bin = I % 2;
            s.push(bin);
            I = I / 2;
        }
        while (!s.empty()) {
           System.out.print(s.pop());
        }
    }
}
