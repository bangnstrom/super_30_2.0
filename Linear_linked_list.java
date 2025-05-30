public class Linear_linked_list {
    Node root; // containership -linked list contains Nodes

    void insertLeft(int data) {
        Node n = new Node(data);

        if (root == null)
            root = n;
        else {
            n.next = root;
            root = n;
        }
        System.out.println(data + " inserted");
    }

    void insertRight(int data) {
        Node t = new Node(data);

        if (root == null) {
            root = t;
        } else {
            Node n = root;
            while (n.next != null) {
                n = n.next;
            }
            n.next = t;
        }
    }

    void deleteLeft() {
        if (root == null)
            System.out.println("Linked list not there");
        else {
            Node t = root;
            root = root.next;
            System.out.println(t.data + " Deleted");
        }
    }

    void deleteRight() {
        if (root == null) {
            System.out.println("Linked list is not there");
        } else {
            Node current = root;
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println("right most node deleted");
            current.next = null;
        }
    }

    void deleteRightOther() {
        if (root == null) {
            System.out.println("Linked list is not there");
        } else {
            Node current = root;
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println("right most node deleted");
            current.next = null;
        }
    }

    void printList() {
        if (root == null) {
            System.out.println("linked list is not there");
        } else {
            Node t = root;
            while (t != null) {
                System.out.println("|" + t.data + "|");
                t = t.next;
            }
        }
    }

    void searchelement(int dat) {
        if (root == null) {
            System.out.println("linked list is not there");
        } else {
            Node t = root;
            while (t != null) {
                if (t.data == dat) {
                    System.out.println("|" + t.data + "|");
                } else {
                    System.out.println("data not found");
                }
                t = t.next;
            }
        }
    }

    public void deleteSpecific(int key) {

        if (root == null) {

            System.out.println("Linked list is empty");

            return;

        }

        // Case 1: The key is at the root

        if (root.data == key) {

            System.out.println(key + " is deleted from beginning");

            root = root.next;

            return;

        }

        // Case 2: Key is somewhere in the middle or end

        Node current = root;

        Node previous = null;

        while (current != null && current.data != key) {

            previous = current;

            current = current.next;

        }

        if (current == null) {

            System.out.println(key + " not found in the list");

        } else {

            System.out.println(key + " is deleted from the list");

            previous.next = current.next;

        }

    }

    public void sort() {
        if (root == null)
            return;

        Node i, j;

        for (i = root; i.next != null; i = i.next) {

            for (j = root; j.next != null; j = j.next) {

                if (j.data > j.next.data) {

                    // Swap the data

                    int temp = j.data;

                    j.data = j.next.data;

                    j.next.data = temp;

                }

            }

        }

    }

    public void first_last() {
        Node curr = root;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        Node nnode = new Node(curr.next.data);
        nnode.next = root;
        root = nnode;
        curr.next = null;
    }

    void anticlock_wise(int times) {
        if (root == null) {
            System.out.println("linked list is not there");
            return;
        }

        int length = 0;
        Node temp = root;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        times = times % length; // Optimize if times > length

        while (times-- > 0) {
            Node first = root;
            root = root.next;

            Node current = root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = first;
            first.next = null;
        }

        System.out.println("List rotated anticlockwise " + times + " times");
    }

    void insert_after(int ref, int new_element) {
        if (root == null) {
            System.out.println("linked list is not there");
            return;
        }

        Node current = root;
        while (current != null) {
            if (current.data == ref) {
                Node newNode = new Node(new_element);
                newNode.next = current.next;
                current.next = newNode;
                System.out.println(new_element + " inserted after " + ref);
                return;
            }
            current = current.next;
        }

        System.out.println("Element " + ref + " not found in the list");
    }

    public static void main(String[] args) {
        Linear_linked_list b = new Linear_linked_list();
        b.insertLeft(12);
        b.insertRight(22);
        b.insertRight(1);
        b.insertRight(82);
        b.insertRight(32);
        b.printList();
        b.deleteSpecific(22);
        System.out.println("\n");
        b.printList();
        System.out.println("\n");
        b.sort();
        b.printList();
        System.out.println("\n");
        b.first_last();
        b.printList();
        System.out.println("\n");
        b.anticlock_wise(1);
        b.printList();
        System.out.println("\n");
        b.insert_after(32,65);
        b.printList();

    }
}
