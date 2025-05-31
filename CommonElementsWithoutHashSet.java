class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null)
            head = newNode;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static void findCommonElements(LinkedList list1, LinkedList list2) {
        Node temp1 = list1.head;
        System.out.println("Common elements:");
        while (temp1 != null) {
            Node temp2 = list2.head;
            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    // Check if already printed
                    if (!isAlreadyPrinted(list1.head, temp1.data, temp1)) {
                        System.out.print(temp1.data + " ");
                    }
                    break;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        System.out.println();
    }

    static boolean isAlreadyPrinted(Node head, int value, Node current) {
        Node temp = head;
        while (temp != current) {
            if (temp.data == value) return true;
            temp = temp.next;
        }
        return false;
    }
}

public class CommonElementsWithoutHashSet {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);

        list2.insert(3);
        list2.insert(4);
        list2.insert(5);
        list2.insert(1);

        System.out.print("List 1: ");
        list1.printList();

        System.out.print("List 2: ");
        list2.printList();

        LinkedList.findCommonElements(list1, list2);
    }
}
