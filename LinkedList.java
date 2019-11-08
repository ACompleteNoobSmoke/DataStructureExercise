public class LinkedList{
    Node head;

    public void insertAtStart(Peeps C){
        Node node = new Node();
        node.MyPeeps  = C;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void insert(Peeps C){
        Node node = new Node();
        node.MyPeeps = C;
        node.next = null;

        if(head == null){
            insertAtStart(C);
        }else{
            Node n = head;
            while(n.next != null){
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAt(int index, Peeps C){
        if(index == 0){
            insertAtStart(C);
        }

        Node node = new Node();
        node.MyPeeps = C;
        
        Node n = head;
        for(int i = 0; i < index - 1; i++){
            n = n.next;
        }
       node.next = n.next;
       n.next = node;
    }

    public void show(){
        Node node = new Node();
        node = head;
     

        while(node.next != null){
            System.out.println(node.MyPeeps);
            node = node.next;
        }
        System.out.println(node.MyPeeps);
    }
}