
//push : it inserts an element on TOS(top of the stack)
// pop : removes and returns top most element from tos
// isfull : check wheather the stack is full or not (if tos maxsize == -1)
// isempty : check wheather the stack is empty or not (if tos ==-1)
// peek : only retuns top most element from tos
// print : in LIFO manner if stack has data

public class stack_class {
    private int s[];
    private int Maxsize, tos;

    public stack_class(int size) {
        Maxsize = size;
    }

    public void push(int e)// push:inserts an element on TOS
    {
        if (isfull() == true) {
            System.out.println("stack is full you cannot insert more data");
        } else {
            tos++;
            s[tos] = e;
            // s[++tos]=e;
            System.out.println(e + " pushed.");
        }

    }

    public boolean isfull() {
        if (tos == Maxsize - 1)
            return true;
        else
            return false;
    }

    public boolean isempty() {
        if (tos == -1) {
            System.out.println("stack is empty");
            return true;
        } else {
            System.out.println("stack is not empty");
            return false;
        }
    }

    public int pop() {

        if (isempty() == true) {
            System.out.println("stack is empty,there is nothing in stack");
        } else {
            int temp = s[tos];
            tos--;
            return temp;
            // return(s[tos--]);
        }
        return 0;

    }

    public int peek() {
        return (s[tos]);
    }

    void print_stack() {
        for (int i = tos; i > -1; i--) {
            System.out.println(s[i]);
        }
    }
    // add the menu driven part from here
}
