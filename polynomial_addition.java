import java.util.Scanner;



class PolyList {
    Pnode root;

    void insert(int pow, double co) {
        Pnode n = new Pnode(pow, co);

        if (root == null) {
            root = n;
        } else {
            Pnode t = root;
            while (t.next != null) t = t.next;
            t.next = n;
        }
    }

    void printList() {
        if (root == null) {
            System.out.println("List is empty");
        } else {
            Pnode t = root;
            while (t != null) {
                System.out.print(t.co + "X^" + t.pow);
                t = t.next;
                if (t != null) {
                    System.out.print(" + ");
                }
            }
            System.out.println(); // for new line
        }
    }
}

public class polynomial_addition {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        PolyList one = new PolyList();
        PolyList two = new PolyList();
        PolyList ans = new PolyList();

        System.out.println("For list one give max power:");
        int power = in.nextInt();

        while (power >= 0) {
            System.out.println("For power " + power + " enter co:");
            double co = in.nextDouble();
            if (co != 0) {
                one.insert(power, co);
            }
            power--;
        }

        System.out.println("Polynomial 1:");
        one.printList();

        System.out.println("For list two give max power:");
        power = in.nextInt();

        while (power >= 0) {
            System.out.println("For power " + power + " enter co:");
            double co = in.nextDouble();
            if (co != 0) {
                two.insert(power, co);
            }
            power--;
        }

        System.out.println("Polynomial 2:");
        two.printList();

        Pnode r1 = one.root;
        Pnode r2 = two.root;

        while (r1 != null && r2 != null) {
            if (r1.pow > r2.pow) {
                ans.insert(r1.pow, r1.co);
                r1 = r1.next;
            } else if (r2.pow > r1.pow) {
                ans.insert(r2.pow, r2.co);
                r2 = r2.next;
            } else {
                ans.insert(r1.pow, r1.co + r2.co);
                r1 = r1.next;
                r2 = r2.next;
            }
        }

        while (r1 != null) {
            ans.insert(r1.pow, r1.co);
            r1 = r1.next;
        }

        while (r2 != null) {
            ans.insert(r2.pow, r2.co);
            r2 = r2.next;
        }

        System.out.println("Final Answer of addition:");
        ans.printList();

        in.close();
    }
}
