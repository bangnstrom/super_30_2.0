import java.util.Stack;
import java.util.Scanner;

public class balance_check {

    static boolean check(String Pattern) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < Pattern.length(); i++) {
            if(Pattern.charAt(i)=='{' || Pattern.charAt(i)=='{' ){
                s.push(Pattern.charAt(i));
            }
            if(Pattern.charAt(i) == '}' || Pattern.charAt(i)==')' ){
                if(!s.empty()){
                    s.pop();
                }
                else{
                    return false; 
                }
            }
            return (s.empty());
        }

        return true;

    }

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Pattern to check:");
        String p = in.next();// read word
        System.out.println("Given Pattern" + p + " balanced:" + check(p));

        // push each character and then pop each to some string
        // o/p:reverse word
    }
}
