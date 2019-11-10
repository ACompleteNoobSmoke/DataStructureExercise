public class LinkedList{
    Node head;

    public void insertAtStart(Peeps C){
        Node node = new Node();
        node.MyPeeps = C;
        node.Next = head;
        head = node;
        
    }

    public void insert(Peeps C){
        if(head == null){
            insertAtStart(C);
        }else{
            Node node = new Node();
            node.MyPeeps = C;
            node.Next = null;

            Node n = head;
            while(n.Next != null){
                n = n.Next;
            }
            n.Next = node;
        }
    }

    public void insertAt(int index, Peeps C){
        if(index == 0){
            insertAtStart(C);
        }else{
            Node node = new Node();
            node.MyPeeps = C;
            
            Node n = head;
            for(int i = 0; i < index - 1; i++){
                n = n.Next;
            }
            node.Next = n.Next;
            n.Next = node;
        }
    }

    public void delete(int index){
     if(index == 0){
         head = head.Next;
     }else{
         Node n = head;
         Node n1 = null;

         for(int i = 0; i < index - 1; i++){
             n = n.Next;
         }
         n1 = n.Next;
         n.Next = n1.Next;

         System.out.println(n1.MyPeeps.getName() + " and " + n1.MyPeeps.getPet().getPetName() + " Has Been Deleted!\n");
     }

    }

    public void ShowAll(){
        Node n = head;

        while(n.Next != null){
            System.out.println(n.MyPeeps.Profile());
            n = n.Next;
        }
        System.out.println(n.MyPeeps.Profile());
        System.out.println("\n**Press Anything To Continue**\n");
    }

}