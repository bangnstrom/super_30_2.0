public class queueUsingLinkedList {
    Node front,rear = null;
    
    void insert(int data){
        Node n = new Node(data);
        if(front == null){
            front = n;
            rear = n;
        }
        else{
            rear.next = n;
            rear = n;
        }
        System.out.println("Node Inserted");
    }

    void delete(){
        
    }



    
}
