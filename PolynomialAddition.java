class PolyNode {
    int coeff;
    int exp;
    PolyNode next;

    PolyNode(int coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
        this.next = null;
    }
}


class Polynomial {
    private PolyNode head;

    public void addTerm(int coeff, int exp) {
        if (coeff == 0) return; 

        PolyNode newNode = new PolyNode(coeff, exp);

        if (head == null || head.exp < exp) {
            newNode.next = head;
            head = newNode;
        } else {
            PolyNode current = head;
            PolyNode prev = null;
            while (current != null && current.exp > exp) {
                prev = current;
                current = current.next;
            }
            if (current != null && current.exp == exp) {
                current.coeff += coeff;
                if (current.coeff == 0) { 
                    if (prev == null) head = current.next;
                    else prev.next = current.next;
                }
            } else {
                newNode.next = current;
                if (prev != null) prev.next = newNode;
            }
        }
    }

    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        PolyNode t1 = p1.head;
        PolyNode t2 = p2.head;

        while (t1 != null && t2 != null) {
            if (t1.exp == t2.exp) {
                int sumCoeff = t1.coeff + t2.coeff;
                if (sumCoeff != 0) result.addTerm(sumCoeff, t1.exp);
                t1 = t1.next;
                t2 = t2.next;
            } else if (t1.exp > t2.exp) {
                result.addTerm(t1.coeff, t1.exp);
                t1 = t1.next;
            } else {
                result.addTerm(t2.coeff, t2.exp);
                t2 = t2.next;
            }
        }

        while (t1 != null) {
            result.addTerm(t1.coeff, t1.exp);
            t1 = t1.next;
        }

        while (t2 != null) {
            result.addTerm(t2.coeff, t2.exp);
            t2 = t2.next;
        }

        return result;
    }

    public void print() {
        if (head == null) {
            System.out.println("0");
            return;
        }
        PolyNode current = head;
        StringBuilder sb = new StringBuilder();

        while (current != null) {
            if (current.coeff > 0 && current != head) sb.append(" + ");
            else if (current.coeff < 0) sb.append(" - ");

            int absCoeff = Math.abs(current.coeff);

            if (absCoeff != 1 || current.exp == 0) sb.append(absCoeff);

            if (current.exp != 0) sb.append("x");

            if (current.exp > 1) sb.append("^").append(current.exp);

            current = current.next;
        }
        System.out.println(sb.toString());
    }
}

public class PolynomialAddition {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.addTerm(5, 3);
        p1.addTerm(4, 2);
        p1.addTerm(2, 0);

        Polynomial p2 = new Polynomial();
        p2.addTerm(3, 3);
        p2.addTerm(-4, 2);
        p2.addTerm(6, 1);

        System.out.print("Polynomial 1: ");
        p1.print();

        System.out.print("Polynomial 2: ");
        p2.print();

        Polynomial result = Polynomial.add(p1, p2);
        System.out.print("Sum: ");
        result.print();
    }
}
