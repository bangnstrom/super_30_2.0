import java.util.Stack;
import java.util.Scanner;

public class reverse_string {
    public static void main(String[]arg){
        Stack<Character> stack = new Stack<>();

        Scanner in =new Scanner(System.in);
        System.out.println("enter the word to reverse");
        //read word
        String word = in.next();
        String rword = "";
        Stack<Character> s = new Stack<>();
        for(int i =0;i<word.length();i++){
            s.push(word.charAt(i));
        }
        for(int i =0;i<word.length();i++){
            rword+=s.pop();
        }
        System.out.println("reversed string: "+rword);

    }
}
