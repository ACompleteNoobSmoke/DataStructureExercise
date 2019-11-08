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

    public void deleteAt(int index){
        if(index == 0){
            head = head.next;
        }else{
            Node n = head;
            Node n1 = null;
            for(int i =0; i < index - 1; i++){
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            System.out.println(n1.MyPeeps.getName() + " has been deleted" );
        }

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