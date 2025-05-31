public class SULinked_List {

  Node root;

  void Push(int data) {

    Node n = new Node(data);

    if (root == null) {

      root = n;

    } else {

      n.next = root;

      root = n;

    }

    System.out.println("inserted in left " + data);

  }

  void Pop() {

    if (root != null) {

      Node d = root;

      root = root.next;

      System.out.println(d.data + " Deleted");

    }

  }

  void print() {

    if (root == null) {

      System.out.println("Linked list is empty");

    } else {

      Node current = root;

      System.out.print("Linked list:- ");

      while (current != null) {

        System.out.print(current.data + " ");

        current = current.next;

      }

      System.out.println("");

    }

  }

  public static void main(String[] args) {

    // TODO Auto-generated method stub

    SULinked_List list = new SULinked_List();

    list.Push(10);

    list.Push(20);

    list.Push(30);

    list.Push(40);

    list.Push(50);

    list.Push(60);

    list.Pop();

    list.Pop();

    list.print();

  }

}
